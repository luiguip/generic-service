package tech.swapy.generic_service.comunication.client;

import java.io.Serializable;
import java.util.List;

import tech.swapy.generic_service.controller.BaseComunicationModel;
import tech.swapy.generic_service.domain.BaseDomainModel;

public interface BaseClient<E extends BaseDomainModel, ID extends Serializable> {

	public abstract E save(E domainModel);

	public abstract List<E> findAll();

	public abstract E findById(ID entityId);

	public abstract E updateById(ID entityId, E domainModel);

	public abstract void deleteById(ID entityId);

}
