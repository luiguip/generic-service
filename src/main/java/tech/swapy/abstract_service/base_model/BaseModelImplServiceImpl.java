package tech.swapy.abstract_service.base_model;

import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.BaseModel;
import tech.swapy.abstract_service.base.BaseRepository;
import tech.swapy.abstract_service.base.BaseServiceImpl;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseModelImpl, Long>{

	public BaseModelImplServiceImpl(BaseRepository<BaseModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
