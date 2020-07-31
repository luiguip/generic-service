package tech.swapy.abstract_service.base.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import tech.swapy.abstract_service.base.persistence.BaseEntity;

public interface BaseService<E extends BaseDomainModel, ID extends Serializable>{
	
    public abstract E save(E entity);
    public abstract List<E> findAll();
    public abstract Optional<E> findById(ID entityId);
    public abstract E update(E entity);
    public abstract E updateById(E entity, ID entityId);   
    public abstract void delete(E entity);
    public abstract void deleteById(ID entityId);
    
}