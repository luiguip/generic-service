package tech.swapy.generic_service.impl.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.generic_service.impl.base.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.impl.base.controller.rest.BaseRestController;
import tech.swapy.generic_service.impl.base.domain.BaseService;
import tech.swapy.generic_service.impl.controller.BaseComunicationModelImpl;
import tech.swapy.generic_service.impl.impl.domain.BaseDomainModelImpl;

@RestController
@RequestMapping(value = "/base")
public class BaseModelImplRestController
		extends BaseRestController<BaseComunicationModelImpl, BaseDomainModelImpl, Long> {

	public BaseModelImplRestController(BaseService<BaseDomainModelImpl, Long> baseService,
			BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelConverter) {
		super(baseService, baseComunicationModelConverter);
	}
}
