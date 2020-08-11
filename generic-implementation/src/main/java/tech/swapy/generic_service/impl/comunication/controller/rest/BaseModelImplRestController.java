package tech.swapy.generic_service.impl.comunication.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.generic_service.comunication.controller.rest.BaseRestController;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.domain.BaseService;
import tech.swapy.generic_service.impl.comunication.BaseComunicationModelImpl;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;

@RestController
@RequestMapping(value = "/base")
public class BaseModelImplRestController
		extends BaseRestController<BaseComunicationModelImpl, BaseDomainModelImpl, Long> {

	public BaseModelImplRestController(BaseService<BaseDomainModelImpl, Long> baseService,
			BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelConverter) {
		super(baseService, baseComunicationModelConverter);
	}
}
