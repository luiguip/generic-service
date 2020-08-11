package tech.swapy.generic_service.impl.comunication;

import java.time.LocalDateTime;

import tech.swapy.generic_service.controller.BaseComunicationModel;

public class BaseComunicationModelImpl extends BaseComunicationModel {

	public BaseComunicationModelImpl() {
		super();
	}

	public BaseComunicationModelImpl(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, createdAt, updatedAt);
	}
}
