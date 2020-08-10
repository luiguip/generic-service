package tech.swapy.generic_service.impl.domain;

import org.springframework.stereotype.Service;

import tech.swapy.generic_service.domain.BaseServiceImpl;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;
import tech.swapy.generic_service.persistence.BaseRepository;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseDomainModelImpl, Long> {

	public BaseModelImplServiceImpl(BaseRepository<BaseEntityImpl, BaseDomainModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
