package tech.swapy.abstract_service.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseModelTests {

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
	public void equalsMinimumRequirements() {
		BaseModel baseModel = new BaseModel();
		assertFalse(baseModel.equals(new String()));
		assertFalse(baseModel.equals(null));
		baseModel.setId(null);
		assertFalse(baseModel.equals(baseModel));
	}

	@Test
	public void differentIds() {
		BaseModel baseModel = this.cloneBaseModel(this.baseModelX);
		baseModel.setId(baseModel.getId() + 1);
		assertFalse(baseModel.equals(this.baseModelX));
	}

	@Test
	public void differentCreatedAt() {
		BaseModel baseModel = new BaseModel(baseModelX);
		baseModel.setCreatedAt(LocalDateTime.now().plusSeconds(1));
		baseModel.setUpdatedAt(this.baseModelX.getUpdatedAt());
		assertFalse(baseModel.equals(this.baseModelX));
	}

	@Test
	public void differentUpdatedAt() {
		BaseModel baseModel = new BaseModel(baseModelX);
		baseModel.setUpdatedAt(LocalDateTime.now().plusSeconds(1));
		assertFalse(baseModel.equals(this.baseModelX));
	}

	@Test
	public void reflexivity() {
		assertTrue(this.baseModelX.equals(this.baseModelX));
	}

	@Test
	public void symmetricity() {
		assertTrue(this.baseModelX.equals(this.baseModelY));
		assertTrue(this.baseModelY.equals(this.baseModelX));
	}

	@Test
	public void transitivity() {
		assertTrue(this.baseModelX.equals(this.baseModelY));
		assertTrue(this.baseModelY.equals(this.baseModelZ));
		assertTrue(this.baseModelX.equals(this.baseModelZ));
	}

	@Test
	public void consistency() {
		assertTrue(this.baseModelX.equals(this.baseModelY));
	}

	@Test
	public void falseOnNull() {
		assertFalse(this.baseModelX.equals(null));
	}

	@Test
	public void hashCodeEquity() {
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
