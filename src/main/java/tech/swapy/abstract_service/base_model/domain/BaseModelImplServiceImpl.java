package tech.swapy.abstract_service.base_model.domain;

import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.domain.BaseServiceImpl;
import tech.swapy.abstract_service.base.persistence.BaseRepository;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseDomainModelImpl, Long>{

	public BaseModelImplServiceImpl(BaseRepository<BaseEntityImpl, BaseDomainModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
