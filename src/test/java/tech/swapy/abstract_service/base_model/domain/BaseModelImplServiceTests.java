package tech.swapy.abstract_service.base_model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tech.swapy.abstract_service.base.domain.BaseService;
import tech.swapy.abstract_service.base.persistence.BaseRepository;
import tech.swapy.abstract_service.base_model.commons.BaseDomainModelImplTestCommons;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@ExtendWith(MockitoExtension.class)
class BaseModelImplServiceTests {

	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	@Autowired
	private BaseService<BaseDomainModelImpl, Long> baseModelImplService;

	@Mock
	private BaseRepository<BaseEntityImpl, BaseDomainModelImpl, Long> baseEntityImplRepositoryImpl;

	@BeforeEach
	void init() {
		baseModelImplService = new BaseModelImplServiceImpl(baseEntityImplRepositoryImpl);
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldSave() {
		baseDomainModelImplY.setId(null);
		when(baseEntityImplRepositoryImpl.save(baseDomainModelImplY)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.save(baseDomainModelImplY)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldFindAll() {
		when(baseEntityImplRepositoryImpl.findAll()).thenReturn(baseDomainModelImplList);
		assertThat(baseModelImplService.findAll()).isEqualTo(baseDomainModelImplList);
	}

	@Test
	void shouldFindById() {
		when(baseEntityImplRepositoryImpl.findById(1L)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.findById(1L)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotFindById() {
		when(baseEntityImplRepositoryImpl.findById(1L)).thenReturn(null);
		assertThat(baseModelImplService.findById(1L)).isNull();
	}

	@Test
	void shouldUpdateById() {
		when(baseEntityImplRepositoryImpl.updateById(baseDomainModelImplX, 1L)).thenReturn(baseDomainModelImplX);
		assertThat(baseModelImplService.updateById(1L, baseDomainModelImplX)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotUpdateById() {
		when(baseEntityImplRepositoryImpl.updateById(baseDomainModelImplX, 1L)).thenReturn(null);
		assertThat(baseModelImplService.updateById(1L, baseDomainModelImplX)).isNull();
	}

	@Test
	void shouldDeleteById() {
		doNothing().when(baseEntityImplRepositoryImpl).deleteById(1L);
		assertDoesNotThrow(() -> baseModelImplService.deleteById(1L));
	}
}
