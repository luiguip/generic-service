package tech.swapy.generic_service.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
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
	}

	public void create() {
		setCreatedAt(LocalDateTime.now());
		setUpdatedAt(LocalDateTime.now());
	}

	public void update(BaseDomainModel baseDomainModel) {
		setUpdatedAt(LocalDateTime.now());
	}
}
