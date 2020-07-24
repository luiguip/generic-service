package tech.swapy.abstract_service.base;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BaseModelTests {

	BaseModel baseModelX = this.createBaseModel();
	BaseModel baseModelY = this.cloneBaseModel(baseModelX);
	BaseModel baseModelZ = this.cloneBaseModel(baseModelY);
	
	@Test
	public void equalsMinimumRequirements() {
		BaseModel baseModel = new BaseModel();
		assertFalse(baseModel.equals(new String()));
		assertFalse(baseModel.equals(null));
		baseModel.setId(null);
		assertFalse(baseModel.equals(baseModel));
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
	

	public BaseModel createBaseModel() {
		BaseModel baseModel = new BaseModel();
		baseModel.setId(1L);
		return baseModel;
	}

	public BaseModel cloneBaseModel(BaseModel baseModel) {
		BaseModel baseModelClone = new BaseModel(baseModel);
		baseModelClone.setUpdatedAt(baseModel.getUpdatedAt());
		return baseModelClone;
	}

}
