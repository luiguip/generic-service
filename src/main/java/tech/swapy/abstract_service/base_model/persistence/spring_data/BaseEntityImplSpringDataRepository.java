package tech.swapy.abstract_service.base_model.persistence.spring_data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Repository
@Primary
public interface BaseEntityImplSpringDataRepository<T extends BaseEntityImpl, ID extends Long> extends BaseSpringDataRepository<T, ID> {

}
