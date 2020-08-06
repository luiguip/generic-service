package tech.swapy.generic_service.impl.commons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import tech.swapy.generic_service.persistency.BaseEntity;

public class BaseEntityTestCommons {

	public static BaseEntity createBaseEntity() {
		return new BaseEntity(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseEntity createBaseEntity(Long id, int seconds) {
		return new BaseEntity(id, LocalDateTime.now().minusSeconds(seconds),
				LocalDateTime.now().minusSeconds(seconds));
	}

	public static BaseEntity cloneBaseEntity(BaseEntity baseEntity) {
		return new BaseEntity(baseEntity.getId(), baseEntity.getCreatedAt(), baseEntity.getUpdatedAt());
	}

	public static List<BaseEntity> createBaseEntityListImpl() {
		return Arrays.asList(createBaseEntity(), createBaseEntity(2L, 1));
	}
}
