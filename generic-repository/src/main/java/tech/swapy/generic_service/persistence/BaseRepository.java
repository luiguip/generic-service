package tech.swapy.generic_service.persistence;

import java.io.Serializable;
import java.util.List;

import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.persistency.BaseEntity;

public interface BaseRepository<T extends BaseEntity, E extends BaseDomainModel, ID extends Serializable> {

	public abstract E save(E domainModel);

	public abstract List<E> findAll();

	public abstract E findById(ID entityId);

	public abstract E updateById(ID entityId, E domainModel);

	public abstract void deleteById(ID entityId);
}
