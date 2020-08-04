package tech.swapy.abstract_service.base_model.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.abstract_service.base.controller.BaseComunicationModelConverter;
import tech.swapy.abstract_service.base.controller.rest.BaseRestController;
import tech.swapy.abstract_service.base.domain.BaseService;
import tech.swapy.abstract_service.base_model.controller.BaseComunicationModelImpl;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

@RestController
@RequestMapping(value = "/base")
public class BaseModelImplRestController
		extends BaseRestController<BaseComunicationModelImpl, BaseDomainModelImpl, Long> {

	public BaseModelImplRestController(BaseService<BaseDomainModelImpl, Long> baseService,
			BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelConverter) {
		super(baseService, baseComunicationModelConverter);
	}
}
