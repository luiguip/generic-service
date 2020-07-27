package tech.swapy.abstract_service.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseModelTests {

	BaseModel baseModelX;
	BaseModel baseModelY;
	BaseModel baseModelZ;

	@BeforeEach
	public void init() {
		this.baseModelX = this.createBaseModel();
		this.baseModelY = this.cloneBaseModel(baseModelX);
		this.baseModelZ = this.cloneBaseModel(baseModelY);
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
	void shouldEqualsBeFalseWithNullId() {
		baseModelX.setId(null);
		assertFalse(baseModelX.equals(baseModelX));
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
	void hashCodeEquity() {
		assertEquals(this.baseModelX.hashCode(), this.baseModelZ.hashCode());
	}

	private BaseModel createBaseModel() {
		BaseModel baseModel = new BaseModel();
		baseModel.setId(1L);
		return baseModel;
	}

	private BaseModel cloneBaseModel(BaseModel baseModel) {
		BaseModel baseModelClone = new BaseModel(baseModel);
		baseModelClone.setUpdatedAt(baseModel.getUpdatedAt());
		return baseModelClone;
	}
}
