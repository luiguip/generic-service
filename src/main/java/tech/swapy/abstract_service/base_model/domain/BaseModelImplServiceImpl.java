package tech.swapy.abstract_service.base_model.domain;

import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.domain.BaseServiceImpl;
import tech.swapy.abstract_service.base.persistence.BaseRepository;
import tech.swapy.abstract_service.base_model.persistence.BaseModelImpl;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseModelImpl, Long>{

	public BaseModelImplServiceImpl(BaseRepository<BaseModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
