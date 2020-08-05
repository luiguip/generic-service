package tech.swapy.generic_service.impl.persistence.spring_data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tech.swapy.generic_service.impl.base.domain.exceptions.IdNotFoundException;
import tech.swapy.generic_service.impl.base.persistence.BaseEntityConverter;
import tech.swapy.generic_service.impl.base.persistence.BaseRepository;
import tech.swapy.generic_service.impl.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.impl.commons.BaseEntityImplTestCommons;
import tech.swapy.generic_service.impl.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;
import tech.swapy.generic_service.impl.persistence.spring_data.BaseEntityImplRepositoryImpl;

@ExtendWith(MockitoExtension.class)
class BaseEntityImplRepostioryImplTests {

	private BaseEntityImpl baseEntityImplX;
	private BaseEntityImpl baseEntityImplY;
	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private Optional<BaseEntityImpl> optionalBaseEntityImpl;
	private List<BaseEntityImpl> baseEntityImplList;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	private BaseRepository<BaseEntityImpl, BaseDomainModelImpl, Long> baseEntityImplRepository;

	@Mock
	private BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityConverter;
	@Mock
	private BaseSpringDataRepository<BaseEntityImpl, Long> baseModelImplSpringDataRepository;

	@BeforeEach
	void init() {
		baseEntityImplRepository = new BaseEntityImplRepositoryImpl(baseModelImplSpringDataRepository,
				baseEntityConverter);
		baseEntityImplX = BaseEntityImplTestCommons.createBaseEntityImpl();
		baseEntityImplY = BaseEntityImplTestCommons.cloneBaseEntityImpl(baseEntityImplX);
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		optionalBaseEntityImpl = Optional.of(baseEntityImplX);
		baseEntityImplList = BaseEntityImplTestCommons.createBaseEntityListImpl();
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldSave() {
		baseEntityImplY.setId(null);
		baseDomainModelImplY.setId(null);
		lenient().when(baseEntityConverter.convert(baseDomainModelImplY)).thenReturn(baseEntityImplY);
		lenient().when(baseModelImplSpringDataRepository.save(baseEntityImplY)).thenReturn(baseEntityImplX);
		lenient().when(baseEntityConverter.convert(baseEntityImplX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityImplRepository.save(baseDomainModelImplY)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldFindAll() {
		lenient().when(baseModelImplSpringDataRepository.findAll()).thenReturn(baseEntityImplList);
		lenient().when(baseEntityConverter.convertEntityList(baseEntityImplList)).thenReturn(baseDomainModelImplList);
		assertThat(baseEntityImplRepository.findAll()).isEqualTo(baseDomainModelImplList);
	}

	@Test
	void shouldFindById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(optionalBaseEntityImpl);
		lenient().when(baseEntityConverter.convert(baseEntityImplX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityImplRepository.findById(1L)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotFindById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseEntityImplRepository.findById(2L);
		});
		String expectedMessage = "findById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldUpdateById() {
		lenient().when(baseEntityConverter.convert(baseDomainModelImplX)).thenReturn(baseEntityImplX);
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(optionalBaseEntityImpl);
		lenient().when(baseModelImplSpringDataRepository.save(baseEntityImplX)).thenReturn(baseEntityImplX);
		lenient().when(baseEntityConverter.convert(baseEntityImplX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityImplRepository.updateById(1L, baseDomainModelImplX)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotUpdateById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(Optional.empty());
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseEntityImplRepository.updateById(2L, baseDomainModelImplX);
		});
		String expectedMessage = "updateById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldDeleteById() {
		doNothing().when(baseModelImplSpringDataRepository).deleteById(1L);
		assertDoesNotThrow(() -> baseEntityImplRepository.deleteById(1L));
	}
}
