package tech.swapy.generic_service.persistence.spring_data;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import tech.swapy.generic_service.persistence.BaseEntity;

@NoRepositoryBean
public interface BaseSpringDataRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>{

}
