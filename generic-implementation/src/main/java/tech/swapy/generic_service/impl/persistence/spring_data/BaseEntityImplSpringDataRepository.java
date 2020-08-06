package tech.swapy.generic_service.impl.persistence.spring_data;

import java.io.Serializable;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import tech.swapy.generic_service.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@Repository
@Primary
public interface BaseEntityImplSpringDataRepository<T extends BaseEntity, ID extends Serializable>
		extends BaseSpringDataRepository<T, ID> {

}
