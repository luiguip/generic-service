package tech.swapy.abstract_service.base_model.persistence;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import tech.swapy.abstract_service.base.persistence.BaseEntity;

@Entity
public class BaseEntityImpl extends BaseEntity {

	private static final long serialVersionUID = -7178894912746684212L;

	public BaseEntityImpl() {
		super();
	}

	public BaseEntityImpl(LocalDateTime cratedAt, LocalDateTime updatedAt) {
		super(cratedAt, updatedAt);
	}

	public BaseEntityImpl(Long id, LocalDateTime cratedAt, LocalDateTime updatedAt) {
		super(id, cratedAt, updatedAt);
	}
}
