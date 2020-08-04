package tech.swapy.abstract_service.base_model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import tech.swapy.abstract_service.base.controller.BaseComunicationModelConverter;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

@Component
public class BaseComunicationModelmplConverter
		implements BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> {

	@Override
	public BaseDomainModelImpl convert(BaseComunicationModelImpl baseComunicationModelImpl) {
		return new BaseDomainModelImpl(baseComunicationModelImpl.getId(), baseComunicationModelImpl.getCreatedAt(),
				baseComunicationModelImpl.getUpdatedAt());
	}

	@Override
	public BaseComunicationModelImpl convert(BaseDomainModelImpl baseDomainModelImpl) {
		return new BaseComunicationModelImpl(baseDomainModelImpl.getId(), baseDomainModelImpl.getCreatedAt(),
				baseDomainModelImpl.getUpdatedAt());
	}

	@Override
	public List<BaseDomainModelImpl> convertComunicationModelList(
			List<BaseComunicationModelImpl> baseComunicationModelImplList) {
		List<BaseDomainModelImpl> baseDomainModelImplList = new ArrayList<>();
		baseComunicationModelImplList.forEach(
				(baseComunicationModelImpl) -> baseDomainModelImplList.add(convert(baseComunicationModelImpl)));
		return baseDomainModelImplList;
	}

	@Override
	public List<BaseComunicationModelImpl> convertDomainList(List<BaseDomainModelImpl> baseDomainModelImplList) {
		List<BaseComunicationModelImpl> baseComunicationModelImplList = new ArrayList<>();
		baseDomainModelImplList
				.forEach((baseDomainModelImpl) -> baseComunicationModelImplList.add(convert(baseDomainModelImpl)));
		return baseComunicationModelImplList;
	}
}
