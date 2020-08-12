package tech.swapy.generic_service.comunication.client.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import tech.swapy.generic_service.comunication.client.BaseClient;
import tech.swapy.generic_service.controller.BaseComunicationModel;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.domain.BaseDomainModel;

public class BaseRestClient<T extends BaseComunicationModel, E extends BaseDomainModel, ID extends Serializable> implements BaseClient<E, ID> {

	private Class<T> clazz;

	private WebClient webClient;

	@Autowired
	private BaseComunicationModelConverter<T, E> baseComunicationModelConverter;

	public BaseRestClient(String url, BaseComunicationModelConverter<T, E> baseComunicationModelConverter,
			Class<T> clazz) {
		this.webClient = WebClient.builder().baseUrl(url).build();
		this.baseComunicationModelConverter = baseComunicationModelConverter;
		this.clazz = clazz;
	}

	@Override
	public E save(E domainModel) {
		T response = webClient.post()
				.bodyValue(domainModel)
				.retrieve()
				.bodyToMono(clazz)
				.block();
		return baseComunicationModelConverter.convert(response);
	}

	@Override
	public List<E> findAll() {
		List<T> responseList = webClient.get()
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<T>>(){})
				.block();
		return baseComunicationModelConverter.convertComunicationModelList(responseList);
	}

	@Override
	public E findById(ID entityId) {
		T responseBody = webClient.get()
				.uri("/{id}", entityId)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(clazz)
				.block();
		return baseComunicationModelConverter.convert(responseBody);
	}

	@Override
	public E updateById(ID entityId, E domainModel) {
		T responseBody = webClient.put()
				.uri("/{id}", entityId)
				.bodyValue(domainModel)
				.retrieve()
				.bodyToMono(clazz)
				.block();
		return baseComunicationModelConverter.convert(responseBody);
	}

	@Override
	public void deleteById(ID entityId) {
		webClient.delete()
			.uri("/{id}", entityId)
			.retrieve()
			.toBodilessEntity()
			.block();
	}
}