package tech.swapy.abstract_service.base.domain;

import java.time.LocalDateTime;

public abstract class BaseDomainModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public BaseDomainModel() {
	}
	
	public BaseDomainModel(Long id, LocalDateTime createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	public BaseDomainModel(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

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

	public void create() {
		setCreatedAt(LocalDateTime.now());
		setUpdatedAt(LocalDateTime.now());
	}
	
	public void update(BaseDomainModel baseDomainModel) {
		setUpdatedAt(LocalDateTime.now());
	}
}
