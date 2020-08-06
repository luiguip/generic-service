package tech.swapy.generic_service.impl.commons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;

public class BaseEntityImplTestCommons {

	public static BaseEntityImpl createBaseEntityImpl() {
		return new BaseEntityImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseEntityImpl createBaseEntityImpl(Long id, int seconds) {
		return new BaseEntityImpl(id, LocalDateTime.now().minusSeconds(seconds), LocalDateTime.now().minusSeconds(seconds));
	}

	public static BaseEntityImpl cloneBaseEntityImpl(BaseEntityImpl baseEntityImpl) {
		return new BaseEntityImpl(baseEntityImpl.getId(), baseEntityImpl.getCreatedAt(), baseEntityImpl.getUpdatedAt());
	}

	public static List<BaseEntityImpl> createBaseEntityListImpl() {
		return Arrays.asList(createBaseEntityImpl(), createBaseEntityImpl(2L, 1));
	}
}
