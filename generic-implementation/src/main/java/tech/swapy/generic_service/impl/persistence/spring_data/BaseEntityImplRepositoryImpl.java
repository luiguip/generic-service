package tech.swapy.generic_service.impl.persistence.spring_data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tech.swapy.generic_service.impl.base.persistence.BaseEntityConverter;
import tech.swapy.generic_service.impl.base.persistence.spring_data.BaseRepositoryImpl;
import tech.swapy.generic_service.impl.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.impl.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;

@Service
public class BaseEntityImplRepositoryImpl extends BaseRepositoryImpl<BaseEntityImpl, BaseDomainModelImpl, Long>{

	public BaseEntityImplRepositoryImpl(BaseSpringDataRepository<BaseEntityImpl, Long> baseRepository,
			BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityConverter) {
		super(baseRepository, baseEntityConverter);
	}

}
