package tech.swapy.abstract_service.base.persistence;

import java.util.List;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

public interface BaseEntityConverter<T extends BaseEntity, E extends BaseDomainModel>{

	public abstract E convert(T baseEntity);
	public abstract T convert(E baseDomainModel);
	public abstract List<E> convertEntityList(List<T> baseEntityList);
	public abstract List<T> convertDomainList(List<E> baseDomainModelList);
}
