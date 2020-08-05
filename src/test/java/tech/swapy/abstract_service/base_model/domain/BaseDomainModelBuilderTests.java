package tech.swapy.abstract_service.base_model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

class BaseDomainModelBuilderTests {
	
	private BaseDomainModelImplBuilder baseDomainModelImplBuilder;
	private BaseDomainModel baseDomainModelX;

	@BeforeEach
	void init() {
		baseDomainModelImplBuilder = new BaseDomainModelImplBuilder();
		baseDomainModelX = new BaseDomainModelImpl();
	}

	@Test
	void shouldCreateNewBusinessModel() {
		BaseDomainModel baseDomainModel = baseDomainModelImplBuilder.create();
		assertNotNull(baseDomainModel.getCreatedAt());
		assertNotNull(baseDomainModel.getUpdatedAt());
	}

	@Test
	void shouldCreateAnUpdatedDomainModel() {
		baseDomainModelX.setUpdatedAt(LocalDateTime.now().minusSeconds(1));
		BaseDomainModel baseDomainModelY = baseDomainModelImplBuilder.update(baseDomainModelX);
		assertEquals(baseDomainModelX.getCreatedAt(), baseDomainModelY.getCreatedAt());
		assertNotEquals(baseDomainModelX.getUpdatedAt(), baseDomainModelY.getUpdatedAt());
	}
	
	@Test
	void shouldBuildADomainModel() {
		baseDomainModelX.setUpdatedAt(LocalDateTime.now().minusSeconds(1));
		BaseDomainModel baseDomainModelY = baseDomainModelImplBuilder.build(baseDomainModelX.getId(), baseDomainModelX.getCreatedAt());
		assertEquals(baseDomainModelX.getCreatedAt(), baseDomainModelY.getCreatedAt());
		assertNotEquals(baseDomainModelX.getUpdatedAt(), baseDomainModelY.getUpdatedAt());
	}
}
