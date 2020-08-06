package tech.swapy.generic_service.impl.domain;

import org.springframework.stereotype.Service;

import tech.swapy.generic_service.base.domain.BaseServiceImpl;
import tech.swapy.generic_service.persistence.BaseRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@Service
public class BaseModelImplServiceImpl extends BaseServiceImpl<BaseDomainModelImpl, Long> {

	public BaseModelImplServiceImpl(BaseRepository<BaseEntity, BaseDomainModelImpl, Long> baseRepository) {
		super(baseRepository);
	}

}
