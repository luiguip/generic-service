package tech.swapy.abstract_service.base_model.commons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import tech.swapy.abstract_service.base_model.controller.BaseComunicationModelImpl;


public class BaseComunicationModelImplTestCommons {

	public static BaseComunicationModelImpl createBaseComunicationModelImpl() {
		return new BaseComunicationModelImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseComunicationModelImpl createBaseComunicationModelImpl(Long id, int seconds) {
		return new BaseComunicationModelImpl(id, LocalDateTime.now().plusSeconds(seconds), LocalDateTime.now().plusSeconds(seconds));
	}

	public static BaseComunicationModelImpl cloneBaseComunicationModelImpl(BaseComunicationModelImpl baseComunicationModelImpl) {
		return new BaseComunicationModelImpl(baseComunicationModelImpl.getId(), baseComunicationModelImpl.getCreatedAt(), baseComunicationModelImpl.getUpdatedAt());
	}

	public static List<BaseComunicationModelImpl> createBaseComunicationModelImplListl() {
		return Arrays.asList(createBaseComunicationModelImpl(), createBaseComunicationModelImpl(2L, 1));
	}
}
