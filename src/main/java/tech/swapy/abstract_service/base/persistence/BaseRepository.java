package tech.swapy.abstract_service.base.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

public interface BaseRepository<T extends BaseEntity, E extends BaseDomainModel, ID extends Serializable> {

	public abstract E save(E domainModel);
    public abstract List<E> findAll();
    public abstract E findById(ID entityId);
    public abstract E updateById(E domainModel, ID entityId);
    public abstract void deleteById(ID entityId);
}
