package tech.swapy.abstract_service.base_model.domain;

import java.time.LocalDateTime;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

public class BaseDomainModelImpl  extends BaseDomainModel{

	public BaseDomainModelImpl() {
		super();
	}

	public BaseDomainModelImpl(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
	}

	public BaseDomainModelImpl(Long id, LocalDateTime createdAt) {
		super(id, createdAt);
	}
}
