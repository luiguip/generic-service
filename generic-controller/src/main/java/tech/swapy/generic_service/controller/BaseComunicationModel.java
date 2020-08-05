package tech.swapy.generic_service.controller;

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
public class BaseComunicationModel {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
