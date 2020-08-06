package tech.swapy.generic_service.impl.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistency.BaseEntity;

@Component
public class BaseEntityConverterImpl implements BaseEntityConverter<BaseEntity, BaseDomainModelImpl> {

	@Override
	public BaseEntity convertUpdate(BaseEntity baseEntity, BaseEntity baseEntityChanges) {
		return new BaseEntity(baseEntity.getId(), baseEntity.getCreatedAt(), baseEntityChanges.getUpdatedAt());
	}

	@Override
	public BaseDomainModelImpl convert(BaseEntity baseEntity) {
		return new BaseDomainModelImpl(baseEntity.getId(), baseEntity.getCreatedAt(), baseEntity.getUpdatedAt());
	}

	@Override
	public BaseEntity convert(BaseDomainModelImpl baseDomainModelImpl) {
		return new BaseEntity(baseDomainModelImpl.getId(), baseDomainModelImpl.getCreatedAt(),
				baseDomainModelImpl.getUpdatedAt());
	}

	@Override
	public List<BaseDomainModelImpl> convertEntityList(List<BaseEntity> baseEntityList) {
		List<BaseDomainModelImpl> baseDomainModelImplList = new ArrayList<>();
		baseEntityList.forEach((baseEntity) -> baseDomainModelImplList.add(convert(baseEntity)));
		return baseDomainModelImplList;
	}

	@Override
	public List<BaseEntity> convertDomainList(List<BaseDomainModelImpl> baseDomainModelImplList) {
		List<BaseEntity> baseEntityList = new ArrayList<>();
		baseDomainModelImplList.forEach((baseDomainModelImpl) -> baseEntityList.add(convert(baseDomainModelImpl)));
		return baseEntityList;
	}
}
