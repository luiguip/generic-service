package tech.swapy.generic_service.impl.persistence.spring_data;

import org.springframework.stereotype.Service;

import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistence.spring_data.BaseRepositoryImpl;
import tech.swapy.generic_service.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@Service
public class BaseEntityRepositoryImpl extends BaseRepositoryImpl<BaseEntity, BaseDomainModelImpl, Long> {

	public BaseEntityRepositoryImpl(BaseSpringDataRepository<BaseEntity, Long> baseRepository,
			BaseEntityConverter<BaseEntity, BaseDomainModelImpl> baseEntityConverter) {
		super(baseRepository, baseEntityConverter);
	}

}
