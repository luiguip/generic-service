package tech.swapy.abstract_service.base_model;

import javax.persistence.Entity;

import tech.swapy.abstract_service.base.BaseModel;

@Entity
public class BaseModelImpl extends BaseModel {

	private static final long serialVersionUID = -7178894912746684212L;

	public BaseModelImpl() {
		super();
	}
	
	public BaseModelImpl(BaseModelImpl baseModelImpl) {
		super(baseModelImpl);
	}
}
