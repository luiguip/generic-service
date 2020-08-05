package tech.swapy.generic_service.impl.commons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import tech.swapy.generic_service.impl.impl.domain.BaseDomainModelImpl;

public class BaseDomainModelImplTestCommons {

	public static BaseDomainModelImpl createBaseDomainModelImpl() {
		return new BaseDomainModelImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseDomainModelImpl createBaseDomainModelImpl(Long id, int seconds) {
		return new BaseDomainModelImpl(id, LocalDateTime.now().plusSeconds(seconds), LocalDateTime.now().plusSeconds(seconds));
	}

	public static BaseDomainModelImpl cloneBaseDomainModelImpl(BaseDomainModelImpl baseDomainModelImpl) {
		return new BaseDomainModelImpl(baseDomainModelImpl.getId(), baseDomainModelImpl.getCreatedAt(), baseDomainModelImpl.getUpdatedAt());
	}

	public static List<BaseDomainModelImpl> createBaseDomainModelListImpl() {
		return Arrays.asList(createBaseDomainModelImpl(), createBaseDomainModelImpl(2L, 1));
	}
}
