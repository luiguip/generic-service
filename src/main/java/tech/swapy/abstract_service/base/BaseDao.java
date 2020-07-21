package tech.swapy.abstract_service.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface BaseDao<T extends BaseModel> extends CrudRepository<T, Serializable>{

}
