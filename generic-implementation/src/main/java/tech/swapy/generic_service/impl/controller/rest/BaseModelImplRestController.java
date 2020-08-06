package tech.swapy.generic_service.impl.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.generic_service.base.domain.BaseService;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.controller.rest.BaseRestController;
import tech.swapy.generic_service.impl.controller.BaseComunicationModelImpl;
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
