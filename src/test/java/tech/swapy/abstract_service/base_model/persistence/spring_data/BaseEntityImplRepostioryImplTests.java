package tech.swapy.abstract_service.base_model.persistence.spring_data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tech.swapy.abstract_service.base.domain.BaseService;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.commons.BaseEntityImplTestCommons;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@SpringBootTest
class BaseEntityImplRepostioryImplTests {

	private BaseEntityImpl baseModelImplX;
	private BaseEntityImpl baseModelImplY;
	private Optional<BaseEntityImpl> optionalBaseModelImpl;
	private List<BaseEntityImpl> baseModelImplList;

	@Autowired
	private BaseService<BaseEntityImpl, Long> baseModelImplService;

	@MockBean
	private BaseSpringDataRepository<BaseEntityImpl, Long> baseModelImplRepository;

	@BeforeEach
	void init() {
		baseModelImplX = BaseEntityImplTestCommons.createBaseEntityImpl();
		optionalBaseModelImpl = Optional.of(baseModelImplX);
		baseModelImplY = BaseEntityImplTestCommons.cloneBaseModelImpl(baseModelImplX);
		baseModelImplList = Arrays.asList(baseModelImplX, baseModelImplY);
	}

	@Test
	void shouldSave() {
		baseModelImplY.setId(null);
		when(baseModelImplRepository.save(baseModelImplY)).thenReturn(baseModelImplX);
		assertThat(baseModelImplService.save(baseModelImplY)).isEqualTo(baseModelImplX);
	}
	
	@Test
	void shouldFindAll() {
		when(baseModelImplRepository.findAll()).thenReturn(baseModelImplList);
		assertThat(baseModelImplService.findAll()).isEqualTo(baseModelImplList);
	}

	@Test
	void shouldFindById() {
		when(baseModelImplRepository.findById(1L)).thenReturn(optionalBaseModelImpl);
		assertThat(baseModelImplService.findById(1L)).isPresent();
	}

	@Test
	void shouldNotFindById() {
		when(baseModelImplRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		assertThat(baseModelImplService.findById(1L)).isNotPresent();
	}
	
	@Test
	void shouldUpdate() {
		when(baseModelImplRepository.save(baseModelImplY)).thenReturn(baseModelImplX);
		assertThat(baseModelImplService.update(baseModelImplY)).isEqualTo(baseModelImplX);
	}
	
	@Test
	void shouldUpdateById() {
		when(baseModelImplRepository.findById(1L)).thenReturn(optionalBaseModelImpl);
		when(baseModelImplRepository.save(baseModelImplX)).thenReturn(baseModelImplX);
		assertThat(baseModelImplService.updateById(baseModelImplX, 1L)).isEqualTo(baseModelImplX);
	}
	
	@Test
	void shouldNotUpdateById() {
		when(baseModelImplRepository.findById(1L)).thenReturn(Optional.empty());
		assertThat(baseModelImplService.updateById(baseModelImplX, 1L)).isNull();
	}
	
	@Test
	void shouldDelete() {
		doNothing().when(baseModelImplRepository).delete(baseModelImplX);
		assertDoesNotThrow(() -> baseModelImplService.delete(baseModelImplX));
	}
	
	@Test
	void shouldDeleteById() {
		doNothing().when(baseModelImplRepository).deleteById(1L);
		assertDoesNotThrow(() -> baseModelImplService.deleteById(1L));
	}
}
