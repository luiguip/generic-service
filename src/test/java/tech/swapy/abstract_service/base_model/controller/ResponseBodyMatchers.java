package tech.swapy.abstract_service.base_model.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseBodyMatchers<T> {
	private ObjectMapper objectMapper = new ObjectMapper();

	public ResponseBodyMatchers(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ResultMatcher containsObjectAsJson(Object expectedObject, Class<T> targetClass) {
		return mvcResult -> {
			String json = mvcResult.getResponse().getContentAsString();
			T actualObject = objectMapper.readValue(json, targetClass);
			assertThat(actualObject).isEqualToComparingFieldByField(expectedObject);
		};
	}

	static ResponseBodyMatchers responseBody() {
		ObjectMapper objectMapper = new ObjectMapper();
		return new ResponseBodyMatchers(objectMapper);

	}

}
