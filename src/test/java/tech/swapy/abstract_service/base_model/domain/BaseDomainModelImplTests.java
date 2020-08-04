package tech.swapy.abstract_service.base_model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base_model.commons.BaseDomainModelImplTestCommons;



class BaseDomainModelImplTests {

	BaseDomainModelImpl baseDomainModelImplX;
	BaseDomainModelImpl baseDomainModelImplY;

	@BeforeEach
	void init() {
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
	}

	@Test
	void shouldEqualsBeFalseWithNull() {
		assertFalse(baseDomainModelImplX.equals(null));
	}

	@Test
	void shouldEqualsBeFalseWithAnotherObject() {
		assertFalse(baseDomainModelImplX.equals(new String()));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentIds() {
		baseDomainModelImplY.setId(baseDomainModelImplX.getId() + 1);
		assertFalse(baseDomainModelImplY.equals(baseDomainModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentCreatedAt() {
		baseDomainModelImplY.setCreatedAt(LocalDateTime.now().plusSeconds(1));
		baseDomainModelImplY.setUpdatedAt(baseDomainModelImplX.getUpdatedAt());
		assertFalse(baseDomainModelImplY.equals(baseDomainModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentUpdatedAt() {
		baseDomainModelImplY.setUpdatedAt(LocalDateTime.now().plusSeconds(1));
		assertFalse(baseDomainModelImplY.equals(baseDomainModelImplX));
	}

	@Test
	void shouldEqualsBeTrueWithSameObject() {
		assertTrue(baseDomainModelImplX.equals(baseDomainModelImplX));
	}

	@Test
	void shouldBeTrueWithAnotherObjectWithSameFields() {
		assertTrue(baseDomainModelImplX.equals(baseDomainModelImplY));
	}

	@Test
	void shouldHashCodeBeEqualsWithDifferentObjectsAndSameFields() {
		assertEquals(baseDomainModelImplX.hashCode(), baseDomainModelImplY.hashCode());
	}
}
