package tech.swapy.generic_service.impl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.generic_service.domain.BaseDomainModel;

class BaseDomainModelTests {

	private BaseDomainModel baseDomainModelX;

	@BeforeEach
	void init() {
		baseDomainModelX = new BaseDomainModelImpl();
	}

	@Test
	void shouldCreateNewBusinessModel() {
		BaseDomainModel baseDomainModel = new BaseDomainModelImpl();
		assertNotNull(baseDomainModel.getCreatedAt());
		assertNotNull(baseDomainModel.getUpdatedAt());
	}

	@Test
	void shouldCreateAnUpdatedDomainModel() {
		baseDomainModelX.setUpdatedAt(LocalDateTime.now().minusSeconds(1));
		BaseDomainModel baseDomainModelY = new BaseDomainModelImpl(baseDomainModelX.getId(),
				baseDomainModelX.getCreatedAt());
		assertEquals(baseDomainModelX.getCreatedAt(), baseDomainModelY.getCreatedAt());
		assertNotEquals(baseDomainModelX.getUpdatedAt(), baseDomainModelY.getUpdatedAt());
	}
}
