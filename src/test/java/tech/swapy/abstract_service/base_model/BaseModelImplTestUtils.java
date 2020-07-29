package tech.swapy.abstract_service.base_model;

import java.time.LocalDateTime;

class BaseModelImplTestUtils {

	static BaseModelImpl createBaseModelImpl() {
		return new BaseModelImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	static BaseModelImpl cloneBaseModelImpl(BaseModelImpl baseModelImpl) {
		return new BaseModelImpl(baseModelImpl.getId(), baseModelImpl.getCreatedAt(), baseModelImpl.getUpdatedAt());
	}
}
