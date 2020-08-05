package tech.swapy.abstract_service.base.domain;

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
public class BaseDomainModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public BaseDomainModel(Long id, LocalDateTime createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}
}
