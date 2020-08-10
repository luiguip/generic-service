package tech.swapy.generic_service.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public abstract class BaseDomainModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public BaseDomainModel(Long id, LocalDateTime createdAt) {
		this.id = id;
		this.createdAt = createdAt;
		setUpdatedAt(LocalDateTime.now());
	}

	public BaseDomainModel() {
		setCreatedAt(LocalDateTime.now());
		setUpdatedAt(LocalDateTime.now());
	}
}
