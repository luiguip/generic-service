package tech.swapy.abstract_service.base_model.domain;

import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.domain.BaseServiceImpl;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseEntityImpl, Long>{

	public BaseModelImplServiceImpl(BaseSpringDataRepository<BaseEntityImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
