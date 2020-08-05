package tech.swapy.generic_service.impl.controller;

import java.time.LocalDateTime;

import tech.swapy.generic_service.impl.base.controller.BaseComunicationModel;


public class BaseComunicationModelImpl  extends BaseComunicationModel{

	public BaseComunicationModelImpl() {
		super();
	}

	public BaseComunicationModelImpl(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
	}
}
