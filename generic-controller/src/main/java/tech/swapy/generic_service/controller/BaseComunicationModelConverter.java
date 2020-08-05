package tech.swapy.generic_service.controller;

import java.util.List;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

public interface BaseComunicationModelConverter<T extends BaseComunicationModel, E extends BaseDomainModel>{
	public abstract E convert(T baseEntity);
	public abstract T convert(E baseDomainModel);
	public abstract List<E> convertComunicationModelList(List<T> baseComunicationModelList);
	public abstract List<T> convertDomainList(List<E> baseDomainModelList);
}
