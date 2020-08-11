package tech.swapy.generic_service.impl.comunication.client.rest;

import tech.swapy.generic_service.comunication.client.rest.BaseRestClient;
import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.impl.comunication.BaseComunicationModelImpl;

public class BaseImplRestClient extends BaseRestClient<BaseComunicationModelImpl, BaseDomainModel, Long> {

	public BaseImplRestClient(String url, Class<BaseComunicationModelImpl> clazz) {
		super(url, clazz);
	}
	

}
