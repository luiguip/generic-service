package tech.swapy.abstract_service.base_model.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base_model.commons.BaseEntityImplTestCommons;

class BaseEntityImplTests {

	BaseEntityImpl baseModelImplX;
	BaseEntityImpl baseModelImplY;

	@BeforeEach
	void init() {
		baseModelImplX = BaseEntityImplTestCommons.createBaseEntityImpl();
		baseModelImplY = BaseEntityImplTestCommons.cloneBaseEntityImpl(baseModelImplX);
	}

	@Test
	void shouldEqualsBeFalseWithNull() {
		assertFalse(baseModelImplX.equals(null));
	}

	@Test
	void shouldEqualsBeFalseWithAnotherObject() {
		assertFalse(baseModelImplX.equals(new String()));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentIds() {
		baseModelImplY.setId(baseModelImplX.getId() + 1);
		assertFalse(baseModelImplY.equals(baseModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentCreatedAt() {
		baseModelImplY.setCreatedAt(LocalDateTime.now().plusSeconds(1));
		baseModelImplY.setUpdatedAt(baseModelImplX.getUpdatedAt());
		assertFalse(baseModelImplY.equals(baseModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentUpdatedAt() {
		baseModelImplY.setUpdatedAt(LocalDateTime.now().plusSeconds(1));
		assertFalse(baseModelImplY.equals(baseModelImplX));
	}

	@Test
	void shouldEqualsBeTrueWithSameObject() {
		assertTrue(baseModelImplX.equals(baseModelImplX));
	}

	@Test
	void shouldBeTrueWithAnotherObjectWithSameFields() {
		assertTrue(baseModelImplX.equals(baseModelImplY));
	}

	@Test
	void shouldHashCodeBeEqualsWithDifferentObjectsAndSameFields() {
		assertEquals(baseModelImplX.hashCode(), baseModelImplY.hashCode());
	}
}
