package tech.swapy.abstract_service.base.domain;

import java.time.LocalDateTime;

public class BaseDomainModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static BaseDomainModel create() {
		BaseDomainModel baseDomainModel = new BaseDomainModel();
		baseDomainModel.setCreatedAt(LocalDateTime.now());
		baseDomainModel.setUpdatedAt(LocalDateTime.now());
		return baseDomainModel;
	}

	
}
