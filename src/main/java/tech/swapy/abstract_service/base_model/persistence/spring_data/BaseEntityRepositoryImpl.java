package tech.swapy.abstract_service.base_model.persistence.spring_data;

import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.persistence.BaseEntityConverter;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseRepositoryImpl;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Repository
public class BaseEntityRepositoryImpl extends BaseRepositoryImpl<BaseEntityImpl, BaseDomainModelImpl, Long>{

	public BaseEntityRepositoryImpl(BaseSpringDataRepository<BaseEntityImpl, Long> baseRepository,
			BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityConverter) {
		super(baseRepository, baseEntityConverter);
	}

}
