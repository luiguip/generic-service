package tech.swapy.generic_service.impl.domain;

import org.springframework.stereotype.Service;

import tech.swapy.generic_service.impl.base.domain.BaseServiceImpl;
import tech.swapy.generic_service.impl.base.persistence.BaseRepository;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseDomainModelImpl, Long>{

	public BaseModelImplServiceImpl(BaseRepository<BaseEntityImpl, BaseDomainModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
