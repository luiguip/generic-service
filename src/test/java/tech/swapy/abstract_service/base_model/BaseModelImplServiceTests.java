package tech.swapy.abstract_service.base_model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tech.swapy.abstract_service.base.BaseRepository;
import tech.swapy.abstract_service.base.BaseService;

@SpringBootTest
class BaseModelImplServiceTests {

	private BaseModelImpl noIdBaseModelImpl;
	private BaseModelImpl baseModelImpl;
	private Optional<BaseModelImpl> optionalBaseModelImpl;

	@Autowired
	private BaseService<BaseModelImpl, Long> baseModelImplService;

	@MockBean
	private BaseRepository<BaseModelImpl, Long> baseModelImplRepository;

	@BeforeEach
	void init() {
		baseModelImpl = new BaseModelImpl();
		baseModelImpl.setId(1L);
		optionalBaseModelImpl = Optional.of(baseModelImpl);
		noIdBaseModelImpl = new BaseModelImpl(baseModelImpl);
		noIdBaseModelImpl.setUpdatedAt(baseModelImpl.getUpdatedAt());
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
}
