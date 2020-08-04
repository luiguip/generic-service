package tech.swapy.abstract_service.base.domain;

import java.io.Serializable;
import java.util.List;

import tech.swapy.abstract_service.base.domain.exceptions.IdNotFoundException;

public interface BaseService<E extends BaseDomainModel, ID extends Serializable> {

	public abstract E save(E domainModel);

	public abstract List<E> findAll();

	public abstract E findById(ID entityId) throws IdNotFoundException;

	public abstract E updateById(ID entityId, E domainModel) throws IdNotFoundException;

	public abstract void deleteById(ID entityId);

}