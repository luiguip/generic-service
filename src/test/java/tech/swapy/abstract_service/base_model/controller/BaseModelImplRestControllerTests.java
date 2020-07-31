package tech.swapy.abstract_service.base_model.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tech.swapy.abstract_service.base_model.controller.ResponseBodyMatchers.responseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import tech.swapy.abstract_service.base.domain.BaseService;
import tech.swapy.abstract_service.base_model.commons.BaseEntityImplTestCommons;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseModelImplRestControllerTests {

	private BaseEntityImpl baseModelImplX;
	private BaseEntityImpl baseModelImplY;
	private Optional<BaseEntityImpl> optionalBaseModelImpl;
	private List<BaseEntityImpl> baseModelImplList;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BaseService<BaseEntityImpl, Long> baseModelImplServiceImpl;
	
	@BeforeEach
	void init() {
		baseModelImplX = BaseEntityImplTestCommons.createBaseEntityImpl();
		optionalBaseModelImpl = Optional.of(baseModelImplX);
		baseModelImplY = BaseEntityImplTestCommons.cloneBaseModelImpl(baseModelImplX);
		baseModelImplList = Arrays.asList(baseModelImplX, baseModelImplY);
	}

//	@Test
//	void shouldFindAll() throws Exception {
//		when(baseModelImplServiceImpl.findAll()).thenReturn(baseModelImplList);
//		mockMvc.perform(get("/base"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.").isArray()));
//	}
//	
//	@Test
//	void shouldFindById() throws Exception {
//		when(baseModelImplServiceImpl.findById(1L)).thenReturn(optionalBaseModelImpl);
//		mockMvc.perform(get("/base/1"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(responseBody().containsObjectAsJson(baseModelImplX, BaseModelImpl.class));
//	}
}
