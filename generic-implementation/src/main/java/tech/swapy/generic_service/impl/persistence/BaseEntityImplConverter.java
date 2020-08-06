package tech.swapy.generic_service.impl.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;

@Component
public class BaseEntityImplConverter implements BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> {

	@Override
	public BaseEntityImpl convertUpdate(BaseEntityImpl baseEntity, BaseEntityImpl baseEntityChanges) {
		return new BaseEntityImpl(baseEntity.getId(), baseEntity.getCreatedAt(), baseEntityChanges.getUpdatedAt());
	}

	@Override
	public BaseDomainModelImpl convert(BaseEntityImpl baseEntityImpl) {
		return new BaseDomainModelImpl(baseEntityImpl.getId(), baseEntityImpl.getCreatedAt(),
				baseEntityImpl.getUpdatedAt());
	}

	@Override
	public BaseEntityImpl convert(BaseDomainModelImpl baseDomainModelImpl) {
		return new BaseEntityImpl(baseDomainModelImpl.getId(), baseDomainModelImpl.getCreatedAt(),
				baseDomainModelImpl.getUpdatedAt());
	}

	@Override
	public List<BaseDomainModelImpl> convertEntityList(List<BaseEntityImpl> baseEntityImplList) {
		List<BaseDomainModelImpl> baseDomainModelImplList = new ArrayList<>();
		baseEntityImplList.forEach((baseEntityImpl) -> baseDomainModelImplList.add(convert(baseEntityImpl)));
		return baseDomainModelImplList;
	}

	@Override
	public List<BaseEntityImpl> convertDomainList(List<BaseDomainModelImpl> baseDomainModelImplList) {
		List<BaseEntityImpl> baseEntityImplList = new ArrayList<>();
		baseDomainModelImplList.forEach((baseDomainModelImpl) -> baseEntityImplList.add(convert(baseDomainModelImpl)));
		return baseEntityImplList;
	}
}
