package tech.swapy.abstract_service.base;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BaseModelTests {

	@Test
	public void equals() {
		BaseModel baseModelX = this.createBaseModel();
		BaseModel baseModelY = this.cloneBaseModel(baseModelX);
		BaseModel baseModelZ = this.cloneBaseModel(baseModelY);

		reflexivity(baseModelX);
		symmetricity(baseModelX, baseModelY);
		transitivity(baseModelX, baseModelY, baseModelZ);
		consistency(baseModelX, baseModelY);
		falseOnNull(baseModelX);
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

	public void reflexivity(BaseModel baseModel) {
		assertTrue(baseModel.equals(baseModel));
	}

	public void symmetricity(BaseModel baseModelX, BaseModel baseModelY) {
		assertTrue(baseModelX.equals(baseModelY));
		assertTrue(baseModelY.equals(baseModelX));
	}

	public void transitivity(BaseModel baseModelX, BaseModel baseModelY, BaseModel baseModelZ) {
		assertTrue(baseModelX.equals(baseModelY));
		assertTrue(baseModelY.equals(baseModelZ));
		assertTrue(baseModelX.equals(baseModelZ));
	}

	public void consistency(BaseModel baseModelX, BaseModel baseModelY) {
		assertTrue(baseModelX.equals(baseModelY));
	}

	public void falseOnNull(BaseModel baseModel) {
		assertTrue(!baseModel.equals(null));
	}
}
