package tech.swapy.generic_service.impl.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.generic_service.impl.commons.BaseEntityTestCommons;
import tech.swapy.generic_service.persistency.BaseEntity;

class BaseEntityImplTests {

	BaseEntity baseModelX;
	BaseEntity baseModelY;

	@BeforeEach
	void init() {
		baseModelX = BaseEntityTestCommons.createBaseEntity();
		baseModelY = BaseEntityTestCommons.cloneBaseEntity(baseModelX);
	}

	@Test
	void shouldEqualsBeFalseWithNull() {
		assertFalse(baseModelX.equals(null));
	}

	@Test
	void shouldEqualsBeFalseWithAnotherObject() {
		assertFalse(baseModelX.equals(new String()));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentIds() {
		baseModelY.setId(baseModelX.getId() + 1);
		assertFalse(baseModelY.equals(baseModelX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentCreatedAt() {
		baseModelY.setCreatedAt(LocalDateTime.now().plusSeconds(1));
		baseModelY.setUpdatedAt(baseModelX.getUpdatedAt());
		assertFalse(baseModelY.equals(baseModelX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentUpdatedAt() {
		baseModelY.setUpdatedAt(LocalDateTime.now().plusSeconds(1));
		assertFalse(baseModelY.equals(baseModelX));
	}

	@Test
	void shouldEqualsBeTrueWithSameObject() {
		assertTrue(baseModelX.equals(baseModelX));
	}

	@Test
	void shouldBeTrueWithAnotherObjectWithSameFields() {
		assertTrue(baseModelX.equals(baseModelY));
	}

	@Test
	void shouldHashCodeBeEqualsWithDifferentObjectsAndSameFields() {
		assertEquals(baseModelX.hashCode(), baseModelY.hashCode());
	}
}
