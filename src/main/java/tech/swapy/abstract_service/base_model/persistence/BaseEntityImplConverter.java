package tech.swapy.abstract_service.base_model.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import tech.swapy.abstract_service.base.persistence.BaseEntityConverter;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

@Component
public class BaseEntityImplConverter implements BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> {

	@Override
	public BaseDomainModelImpl convert(BaseEntityImpl baseEntityImpl) {
		return new BaseDomainModelImpl(baseEntityImpl.getId(), baseEntityImpl.getCreatedAt(), baseEntityImpl.getUpdatedAt());
	}

	@Override
	public BaseEntityImpl convert(BaseDomainModelImpl baseDomainModelImpl) {
		return new BaseEntityImpl(baseDomainModelImpl.getId(), baseDomainModelImpl.getCreatedAt(), baseDomainModelImpl.getUpdatedAt());
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
