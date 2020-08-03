package tech.swapy.abstract_service.base_model.persistence.spring_data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.persistence.BaseEntityConverter;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseRepositoryImpl;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Service
public class BaseEntityImplRepositoryImpl extends BaseRepositoryImpl<BaseEntityImpl, BaseDomainModelImpl, Long>{

	public BaseEntityImplRepositoryImpl(BaseSpringDataRepository<BaseEntityImpl, Long> baseRepository,
			BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityConverter) {
		super(baseRepository, baseEntityConverter);
	}

}
