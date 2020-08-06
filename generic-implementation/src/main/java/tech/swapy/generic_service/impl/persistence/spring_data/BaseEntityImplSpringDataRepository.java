package tech.swapy.generic_service.impl.persistence.spring_data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;
import tech.swapy.generic_service.persistence.spring_data.BaseSpringDataRepository;

@Repository
@Primary
public interface BaseEntityImplSpringDataRepository<T extends BaseEntityImpl, ID extends Long>
		extends BaseSpringDataRepository<T, ID> {

}
