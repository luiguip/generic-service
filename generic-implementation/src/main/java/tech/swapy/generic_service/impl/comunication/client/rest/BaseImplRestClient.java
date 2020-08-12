package tech.swapy.generic_service.impl.comunication.client.rest;

import org.springframework.web.reactive.function.client.WebClient;

import tech.swapy.generic_service.comunication.client.rest.BaseRestClient;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.impl.comunication.BaseComunicationModelImpl;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;

public class BaseImplRestClient extends BaseRestClient<BaseComunicationModelImpl, BaseDomainModelImpl, Long> {

	public BaseImplRestClient(String url,
			BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelConverter,
			Class<BaseComunicationModelImpl> clazz) {
		super(url, baseComunicationModelConverter, clazz);
	}
}
