package tech.swapy.abstract_service.base_model.controller;

import java.time.LocalDateTime;

import tech.swapy.abstract_service.base.controller.BaseComunicationModel;


public class BaseComunicationModelImpl  extends BaseComunicationModel{

	public BaseComunicationModelImpl() {
		super();
	}

	public BaseComunicationModelImpl(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
	}
}
