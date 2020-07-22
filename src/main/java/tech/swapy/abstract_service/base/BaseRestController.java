package tech.swapy.abstract_service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseRestController<T extends BaseModel, ID extends Serializable> {

	@Autowired
	BaseService<T, ID> baseService;

	@GetMapping
	public List<T> findAll() {
		return baseService.findAll();
	}

	@PostMapping
	  public T save(@RequestBody T base) {
	    return baseService.save(base);
	  }

	@GetMapping("{id}")
	public Optional<T> findById(@PathVariable ID id) {
		return baseService.findById(id);
	}

	@PutMapping
	public T update(@RequestBody T base) {
		return baseService.save(base);
	}
	
	@DeleteMapping("{id}")
	void deleteEmployee(@PathVariable ID id) {
		baseService.deleteById(id);
	}
}
