package tech.swapy.generic_service;

import java.util.List;

import tech.swapy.generic_service.controller.BaseComunicationModel;
import tech.swapy.generic_service.domain.BaseDomainModel;

public interface BaseComunicationModelConverter<T extends BaseComunicationModel, E extends BaseDomainModel> {
	public abstract E convert(T baseEntity);

	public abstract E convertCreate(T baseEntity);

	public abstract E convertUpdate(T baseEntity);

	public abstract T convert(E baseDomainModel);

	public abstract List<E> convertComunicationModelList(List<T> baseComunicationModelList);

	public abstract List<T> convertDomainList(List<E> baseDomainModelList);
}
