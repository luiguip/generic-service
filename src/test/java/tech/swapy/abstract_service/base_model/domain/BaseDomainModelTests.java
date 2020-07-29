package tech.swapy.abstract_service.base_model.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;

public class BaseDomainModelTests {
	
	@BeforeEach
	void init() {
		
	}

	@Test
	void shouldCreateNewBusinessModel() {
		BaseDomainModel baseDomainModel = BaseDomainModel.create();
		assertNotNull(baseDomainModel.getCreatedAt());
		assertNotNull(baseDomainModel.getUpdatedAt());
	}
}
