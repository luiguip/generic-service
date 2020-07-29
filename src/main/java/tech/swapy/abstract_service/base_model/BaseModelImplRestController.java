package tech.swapy.abstract_service.base_model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.swapy.abstract_service.base.BaseRestController;

@RestController
@RequestMapping(value = "/base")
public class BaseModelImplRestController extends BaseRestController<BaseModelImpl, Long> {

}
