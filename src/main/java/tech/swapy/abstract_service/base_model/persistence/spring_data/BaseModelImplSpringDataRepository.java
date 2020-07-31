package tech.swapy.abstract_service.base_model.persistence.spring_data;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;
import tech.swapy.abstract_service.base_model.persistence.BaseEntityImpl;

@Repository
public interface BaseModelImplSpringDataRepository<T extends BaseEntityImpl, ID extends Serializable> extends BaseSpringDataRepository<T, ID> {

}
