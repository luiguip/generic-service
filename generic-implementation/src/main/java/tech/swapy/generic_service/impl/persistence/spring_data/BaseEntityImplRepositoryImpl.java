package tech.swapy.generic_service.impl.persistence.spring_data;

import org.springframework.stereotype.Service;

import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistence.spring_data.BaseRepositoryImpl;
import tech.swapy.generic_service.persistence.spring_data.BaseSpringDataRepository;

@Service
public class BaseEntityImplRepositoryImpl extends BaseRepositoryImpl<BaseEntityImpl, BaseDomainModelImpl, Long> {

	public BaseEntityImplRepositoryImpl(BaseSpringDataRepository<BaseEntityImpl, Long> baseRepository,
			BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityConverter) {
		super(baseRepository, baseEntityConverter);
	}

}
