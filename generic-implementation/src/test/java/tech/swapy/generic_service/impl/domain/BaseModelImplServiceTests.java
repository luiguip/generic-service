package tech.swapy.generic_service.impl.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tech.swapy.generic_service.base.domain.BaseService;
import tech.swapy.generic_service.exceptions.IdNotFoundException;
import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.persistence.BaseRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@ExtendWith(MockitoExtension.class)
class BaseModelImplServiceTests {

	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	@Autowired
	private BaseService<BaseDomainModelImpl, Long> baseModelImplService;

	@Mock
	private BaseRepository<BaseEntity, BaseDomainModelImpl, Long> baseEntityRepositoryImpl;

	@BeforeEach
	void init() {
		baseModelImplService = new BaseModelImplServiceImpl(baseEntityRepositoryImpl);
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldSave() {
		baseDomainModelImplY.setId(null);
		when(baseEntityRepositoryImpl.save(baseDomainModelImplY)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.save(baseDomainModelImplY)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldFindAll() {
		when(baseEntityRepositoryImpl.findAll()).thenReturn(baseDomainModelImplList);
		assertThat(baseModelImplService.findAll()).isEqualTo(baseDomainModelImplList);
	}

	@Test
	void shouldFindById() {
		when(baseEntityRepositoryImpl.findById(1L)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.findById(1L)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotFindById() {
		lenient().when(baseEntityRepositoryImpl.findById(1L)).thenThrow(new IdNotFoundException("findById"));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseModelImplService.findById(1L);
		});
		String expectedMessage = "findById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldUpdateById() {
		when(baseEntityRepositoryImpl.updateById(1L, baseDomainModelImplX)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.updateById(1L, baseDomainModelImplX)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotUpdateById() {
		lenient().when(baseEntityRepositoryImpl.updateById(2L, baseDomainModelImplX))
				.thenThrow(new IdNotFoundException("updateById"));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseModelImplService.updateById(2L, baseDomainModelImplX);
		});
		String expectedMessage = "updateById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldDeleteById() {
		doNothing().when(baseEntityRepositoryImpl).deleteById(1L);
		assertDoesNotThrow(() -> baseModelImplService.deleteById(1L));
	}
}
