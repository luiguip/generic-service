package tech.swapy.abstract_service.base_model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

class BaseDomainModelTests {
	
	private BaseDomainModel baseDomainModelX;

	@BeforeEach
	void init() {
		baseDomainModelX = new BaseDomainModel();
		baseDomainModelX.create();
	}

	@Test
	void shouldCreateNewBusinessModel() {
		BaseDomainModel baseDomainModel = new BaseDomainModel();
		baseDomainModel.create();
		assertNotNull(baseDomainModel.getCreatedAt());
		assertNotNull(baseDomainModel.getUpdatedAt());
	}
	
	@Test
	void shouldCreateAnUpdatedDomainModel() {
		baseDomainModelX.setUpdatedAt(LocalDateTime.now().minusSeconds(1));
		BaseDomainModel baseDomainModelY = new BaseDomainModel(baseDomainModelX.getId(), baseDomainModelX.getCreatedAt());
		baseDomainModelY.update(baseDomainModelX);
		assertEquals(baseDomainModelX.getCreatedAt(), baseDomainModelY.getCreatedAt());
		assertNotEquals(baseDomainModelX.getUpdatedAt(), baseDomainModelY.getUpdatedAt());
	}
}
