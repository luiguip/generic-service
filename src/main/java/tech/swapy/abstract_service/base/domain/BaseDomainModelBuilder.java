package tech.swapy.abstract_service.base.domain;

import java.time.LocalDateTime;

public abstract class BaseDomainModelBuilder {

	public BaseDomainModel create() {
		BaseDomainModel baseDomainModel = new BaseDomainModel();
		baseDomainModel.setCreatedAt(LocalDateTime.now());
		baseDomainModel.setUpdatedAt(LocalDateTime.now());
		return baseDomainModel;
	}

	public BaseDomainModel update(BaseDomainModel baseDomainModel) {
		return build(baseDomainModel.getId(), baseDomainModel.getCreatedAt());
	}
	
	public BaseDomainModel build(Long id, LocalDateTime createdAt) {
		BaseDomainModel baseDomainModel = new BaseDomainModel();
		baseDomainModel.setId(id);
		baseDomainModel.setCreatedAt(createdAt);
		baseDomainModel.setUpdatedAt(LocalDateTime.now());
		return baseDomainModel;
	}

}
