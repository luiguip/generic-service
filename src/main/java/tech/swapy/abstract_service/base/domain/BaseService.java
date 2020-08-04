package tech.swapy.abstract_service.base.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import tech.swapy.abstract_service.base.persistence.BaseEntity;

public interface BaseService<E extends BaseDomainModel, ID extends Serializable>{
	
	public abstract E save(E domainModel);
    public abstract List<E> findAll();
    public abstract E findById(ID entityId);
    public abstract E updateById(ID entityId, E domainModel);
    public abstract void deleteById(ID entityId);
    
}