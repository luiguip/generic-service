package tech.swapy.abstract_service.base_model.commons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

public class BaseDomainModelImplTestCommons {

	public static BaseDomainModelImpl createBaseDomainModelImpl() {
		return new BaseDomainModelImpl(1L, LocalDateTime.now(), LocalDateTime.now());
	}

	public static BaseDomainModelImpl createBaseDomainModelImpl(Long id, int seconds) {
		return new BaseDomainModelImpl(id, LocalDateTime.now().plusSeconds(seconds), LocalDateTime.now().plusSeconds(seconds));
	}

	public static BaseDomainModelImpl cloneBaseDomainModelImpl(BaseDomainModelImpl baseModelImpl) {
		return new BaseDomainModelImpl(baseModelImpl.getId(), baseModelImpl.getCreatedAt(), baseModelImpl.getUpdatedAt());
	}

	public static List<BaseDomainModelImpl> createBaseDomainModelListImpl() {
		return Arrays.asList(createBaseDomainModelImpl(), createBaseDomainModelImpl(2L, 1));
	}
}
