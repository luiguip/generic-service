package tech.swapy.abstract_service.base_model.commons;

import java.time.LocalDateTime;

import tech.swapy.abstract_service.base_model.persistence.BaseModelImpl;

public class BaseModelImplTestCommons {

	public static BaseModelImpl createBaseModelImpl() {
		return new BaseModelImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseModelImpl cloneBaseModelImpl(BaseModelImpl baseModelImpl) {
		return new BaseModelImpl(baseModelImpl.getId(), baseModelImpl.getCreatedAt(), baseModelImpl.getUpdatedAt());
	}
}
