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

import tech.swapy.generic_service.exceptions.IdNotFoundException;
import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.impl.commons.BaseEntityTestCommons;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistence.BaseRepository;
import tech.swapy.generic_service.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@ExtendWith(MockitoExtension.class)
class BaseEntityRepostioryImplTests {

	private BaseEntity baseEntityX;
	private BaseEntity baseEntityY;
	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private Optional<BaseEntity> optionalBaseEntity;
	private List<BaseEntity> baseEntityList;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	private BaseRepository<BaseEntity, BaseDomainModelImpl, Long> baseEntityRepository;

	@Mock
	private BaseEntityConverter<BaseEntity, BaseDomainModelImpl> baseEntityConverter;
	@Mock
	private BaseSpringDataRepository<BaseEntity, Long> baseModelImplSpringDataRepository;

	@BeforeEach
	void init() {
		baseEntityRepository = new BaseEntityRepositoryImpl(baseModelImplSpringDataRepository,
				baseEntityConverter);
		baseEntityX = BaseEntityTestCommons.createBaseEntity();
		baseEntityY = BaseEntityTestCommons.cloneBaseEntity(baseEntityX);
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		optionalBaseEntity = Optional.of(baseEntityX);
		baseEntityList = BaseEntityTestCommons.createBaseEntityListImpl();
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldSave() {
		baseEntityY.setId(null);
		baseDomainModelImplY.setId(null);
		lenient().when(baseEntityConverter.convert(baseDomainModelImplY)).thenReturn(baseEntityY);
		lenient().when(baseModelImplSpringDataRepository.save(baseEntityY)).thenReturn(baseEntityX);
		lenient().when(baseEntityConverter.convert(baseEntityX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityRepository.save(baseDomainModelImplY)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldFindAll() {
		lenient().when(baseModelImplSpringDataRepository.findAll()).thenReturn(baseEntityList);
		lenient().when(baseEntityConverter.convertEntityList(baseEntityList)).thenReturn(baseDomainModelImplList);
		assertThat(baseEntityRepository.findAll()).isEqualTo(baseDomainModelImplList);
	}

	@Test
	void shouldFindById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(optionalBaseEntity);
		lenient().when(baseEntityConverter.convert(baseEntityX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityRepository.findById(1L)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotFindById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseEntityRepository.findById(2L);
		});
		String expectedMessage = "findById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldUpdateById() {
		lenient().when(baseEntityConverter.convert(baseDomainModelImplX)).thenReturn(baseEntityX);
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(optionalBaseEntity);
		lenient().when(baseEntityConverter.convertUpdate(optionalBaseEntity.get(), baseEntityX)).thenReturn(baseEntityX); 
		lenient().when(baseModelImplSpringDataRepository.save(baseEntityX)).thenReturn(baseEntityX);
		lenient().when(baseEntityConverter.convert(baseEntityX)).thenReturn(baseDomainModelImplX);
		assertThat(baseEntityRepository.updateById(1L, baseDomainModelImplX)).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldNotUpdateById() {
		lenient().when(baseModelImplSpringDataRepository.findById(1L)).thenReturn(Optional.empty());
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseEntityRepository.updateById(2L, baseDomainModelImplX);
		});
		String expectedMessage = "updateById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldDeleteById() {
		doNothing().when(baseModelImplSpringDataRepository).deleteById(1L);
		assertDoesNotThrow(() -> baseEntityRepository.deleteById(1L));
	}
}
