package tech.swapy.generic_service.persistence;

import java.util.List;

import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.persistency.BaseEntity;

public interface BaseEntityConverter<T extends BaseEntity, E extends BaseDomainModel>{

	public abstract T convertUpdate(T baseEntity, T baseEntityChanges);
	public abstract E convert(T baseEntity);
	public abstract T convert(E baseDomainModel);
	public abstract List<E> convertEntityList(List<T> baseEntityList);
	public abstract List<T> convertDomainList(List<E> baseDomainModelList);
}
