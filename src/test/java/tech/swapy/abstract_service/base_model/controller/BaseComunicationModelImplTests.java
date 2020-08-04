package tech.swapy.abstract_service.base_model.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base_model.commons.BaseComunicationModelImplTestCommons;



class BaseComunicationModelImplTests {

	BaseComunicationModelImpl baseComunicationModelImplX;
	BaseComunicationModelImpl baseComunicationModelImplY;

	@BeforeEach
	void init() {
		baseComunicationModelImplX = BaseComunicationModelImplTestCommons.createBaseComunicationModelImpl();
		baseComunicationModelImplY = BaseComunicationModelImplTestCommons.cloneBaseComunicationModelImpl(baseComunicationModelImplX);
	}

	@Test
	void shouldEqualsBeFalseWithNull() {
		assertFalse(baseComunicationModelImplX.equals(null));
	}

	@Test
	void shouldEqualsBeFalseWithAnotherObject() {
		assertFalse(baseComunicationModelImplX.equals(new String()));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentIds() {
		baseComunicationModelImplY.setId(baseComunicationModelImplX.getId() + 1);
		assertFalse(baseComunicationModelImplY.equals(baseComunicationModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentCreatedAt() {
		baseComunicationModelImplY.setCreatedAt(LocalDateTime.now().plusSeconds(1));
		baseComunicationModelImplY.setUpdatedAt(baseComunicationModelImplX.getUpdatedAt());
		assertFalse(baseComunicationModelImplY.equals(baseComunicationModelImplX));
	}

	@Test
	void shouldEqualsBeFalseWithDifferentUpdatedAt() {
		baseComunicationModelImplY.setUpdatedAt(LocalDateTime.now().plusSeconds(1));
		assertFalse(baseComunicationModelImplY.equals(baseComunicationModelImplX));
	}

	@Test
	void shouldEqualsBeTrueWithSameObject() {
		assertTrue(baseComunicationModelImplX.equals(baseComunicationModelImplX));
	}

	@Test
	void shouldBeTrueWithAnotherObjectWithSameFields() {
		assertTrue(baseComunicationModelImplX.equals(baseComunicationModelImplY));
	}

	@Test
	void shouldHashCodeBeEqualsWithDifferentObjectsAndSameFields() {
		assertEquals(baseComunicationModelImplX.hashCode(), baseComunicationModelImplY.hashCode());
	}
}
