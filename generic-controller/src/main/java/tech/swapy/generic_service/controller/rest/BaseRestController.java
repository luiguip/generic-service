package tech.swapy.generic_service.controller.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tech.swapy.generic_service.base.domain.BaseService;
import tech.swapy.generic_service.controller.BaseComunicationModel;
import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.domain.BaseDomainModel;

public abstract class BaseRestController<T extends BaseComunicationModel, E extends BaseDomainModel, ID extends Serializable> {

	@Autowired
	BaseService<E, ID> baseService;

	@Autowired
	BaseComunicationModelConverter<T, E> baseComunicationModelConverter;

	public BaseRestController(BaseService<E, ID> baseService,
			BaseComunicationModelConverter<T, E> baseComunicationModelConverter) {
		this.baseService = baseService;
		this.baseComunicationModelConverter = baseComunicationModelConverter;
	}

	@GetMapping("{id}")
	public T findById(@PathVariable ID id) {
		return baseComunicationModelConverter.convert(baseService.findById(id));
	}

	@GetMapping
	public List<T> findAll() {
		return baseComunicationModelConverter.convertDomainList(baseService.findAll());
	}

	@PostMapping
	public T save(@RequestBody T base) {
		E baseDomain = baseComunicationModelConverter.convert(base);
		return baseComunicationModelConverter.convert(baseService.save(baseDomain));
	}

	@PutMapping
	public T updateById(@PathVariable ID id, @RequestBody T base) {
		E baseDomain = baseComunicationModelConverter.convert(base);
		return baseComunicationModelConverter.convert(baseService.updateById(id, baseDomain));
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable ID id) {
		baseService.deleteById(id);
	}
}
