package tech.swapy.generic_service.impl.domain;

import java.time.LocalDateTime;

import tech.swapy.generic_service.domain.BaseDomainModel;

public class BaseDomainModelImpl extends BaseDomainModel {

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
