package tech.swapy.abstract_service.base.persistence;

import java.io.Serializable;
import java.util.List;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;
import tech.swapy.abstract_service.base.domain.exceptions.IdNotFoundException;

public interface BaseRepository<T extends BaseEntity, E extends BaseDomainModel, ID extends Serializable> {

	public abstract E save(E domainModel);
    public abstract List<E> findAll();
    public abstract E findById(ID entityId) throws IdNotFoundException;
    public abstract E updateById(ID entityId, E domainModel) throws IdNotFoundException;
    public abstract void deleteById(ID entityId);
}
