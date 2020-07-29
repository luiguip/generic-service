package tech.swapy.abstract_service.base_model.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.abstract_service.base.controller.BaseRestController;
import tech.swapy.abstract_service.base_model.persistence.BaseModelImpl;

@RestController
@RequestMapping(value = "/base")
public class BaseModelImplRestController extends BaseRestController<BaseModelImpl, Long> {

}
