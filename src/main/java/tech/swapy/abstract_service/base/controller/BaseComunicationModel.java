package tech.swapy.abstract_service.base.controller;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.swapy.abstract_service.base.domain.BaseDomainModel;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class BaseComunicationModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
