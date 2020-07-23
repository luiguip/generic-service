package tech.swapy.abstract_service.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID extends Serializable> extends JpaRepository<T, ID>{

}