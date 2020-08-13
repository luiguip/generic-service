package tech.swapy.generic_service.impl.comunication.client.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.impl.commons.BaseComunicationModelImplTestCommons;
import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.impl.comunication.BaseComunicationModelImpl;
import tech.swapy.generic_service.impl.comunication.BaseComunicationModelmplConverter;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;

class BaseImplRestClientTests {

	private BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelConverter = new BaseComunicationModelmplConverter();
	private WebClient webClient;
	private BaseImplRestClient baseImplRestClient;

	static private MockWebServer mockBackEnd;
	static private ObjectMapper objectMapper;
	
	private BaseComunicationModelImpl baseComunicationModelImplX;
	private BaseComunicationModelImpl baseComunicationModelImplY;
	private List<BaseComunicationModelImpl> baseComunicationModelImplList;
	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	@BeforeAll
	static void initAll() throws IOException {
		mockBackEnd = new MockWebServer();
		mockBackEnd.start();
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
	}

	@AfterAll
	static void tearDown() throws IOException {
		mockBackEnd.shutdown();
	}

	@BeforeEach
	void init() throws IOException {

		String baseUrl = String.format("http://localhost:%s/base", mockBackEnd.getPort());
		baseImplRestClient = new BaseImplRestClient(baseUrl, baseComunicationModelConverter,
				BaseComunicationModelImpl.class);

		baseComunicationModelImplX = BaseComunicationModelImplTestCommons.createBaseComunicationModelImpl();
		baseComunicationModelImplY = BaseComunicationModelImplTestCommons
				.cloneBaseComunicationModelImpl(baseComunicationModelImplX);
		baseComunicationModelImplList = BaseComunicationModelImplTestCommons.createBaseComunicationModelImplListl();

		baseDomainModelImplX = new BaseDomainModelImpl(baseComunicationModelImplX.getId(),
				baseComunicationModelImplX.getCreatedAt(), baseComunicationModelImplX.getUpdatedAt());
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldGetBaseComunicationModelById() throws JsonProcessingException {
		mockBackEnd.enqueue(new MockResponse().setBody(objectMapper.writeValueAsString(baseComunicationModelImplX))
				.addHeader("Content-Type", "application/json"));
		BaseDomainModelImpl baseDomainModelRetrieved = baseImplRestClient.findById(baseComunicationModelImplX.getId());
		assertThat(baseDomainModelRetrieved).isEqualTo(baseDomainModelImplX);
	}

	@Test
	void shouldSaveBaseComunicationModel() throws JsonProcessingException {
		mockBackEnd.enqueue(new MockResponse().setBody(objectMapper.writeValueAsString(baseComunicationModelImplX))
				.addHeader("Content-Type", "application/json"));
		baseDomainModelImplX.setId(null);
		BaseDomainModelImpl baseDomainModelRetrieved = baseImplRestClient.save(baseDomainModelImplX);
		assertThat(baseDomainModelRetrieved).isEqualTo(baseDomainModelImplY);
	}
}
