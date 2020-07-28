package tech.swapy.abstract_service.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class BaseServiceTests {

	@TestConfiguration
	static class BaseServiceImplTestContextConfiguration {

		@Bean
		public BaseService<BaseModel, Long> employeeService() {
			return new BaseServiceImpl<BaseModel, Long>() {
			};
		}
	}

	private BaseModel noIdBaseModel;
	private BaseModel baseModel;
	private Optional<BaseModel> optionalBaseModel;

	@Autowired
	private BaseService<BaseModel, Long> baseService;

	@MockBean
	private BaseRepository<BaseModel, Long> baseRepository;

	@BeforeEach
	void init() {
		baseModel = new BaseModel();
		baseModel.setId(1L);
		optionalBaseModel = Optional.of(baseModel);
		noIdBaseModel = new BaseModel(baseModel);
		noIdBaseModel.setUpdatedAt(baseModel.getUpdatedAt());
	}

	@Test
	void shouldFindById() {
		when(baseRepository.findById(1L)).thenReturn(optionalBaseModel);
		assertThat(baseService.findById(1L)).isPresent();
	}

	@Test
	void shouldNotFindById() {
		when(baseRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		assertThat(baseService.findById(1L)).isNotPresent();
	}
}
