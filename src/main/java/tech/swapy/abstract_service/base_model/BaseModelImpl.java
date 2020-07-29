package tech.swapy.abstract_service.base_model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import tech.swapy.abstract_service.base.BaseModel;

@Entity
public class BaseModelImpl extends BaseModel {

	private static final long serialVersionUID = -7178894912746684212L;

	public BaseModelImpl() {
		super();
	}

	public BaseModelImpl(LocalDateTime cratedAt, LocalDateTime updatedAt) {
		super(cratedAt, updatedAt);
	}

	public BaseModelImpl(Long id, LocalDateTime cratedAt, LocalDateTime updatedAt) {
		super(id, cratedAt, updatedAt);
	}
}
