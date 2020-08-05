package tech.swapy.generic_service.impl.persistence.spring_data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import tech.swapy.generic_service.impl.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.impl.persistence.BaseEntityImpl;

@Repository
@Primary
public interface BaseEntityImplSpringDataRepository<T extends BaseEntityImpl, ID extends Long> extends BaseSpringDataRepository<T, ID> {

}
