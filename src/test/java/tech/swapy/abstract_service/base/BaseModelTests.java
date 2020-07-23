package tech.swapy.abstract_service.base;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BaseModelTests {

	@Test
	public void equals() {
		BaseModel baseModelX = this.createBaseModel();

		reflexivity(baseModelX);
	}

	public BaseModel createBaseModel() {
		BaseModel baseModel = new BaseModel();
		baseModel.setId(1L);
		return baseModel;
	}

	public void reflexivity(BaseModel baseModel) {
		assertTrue(baseModel.equals(baseModel));
	}
}
