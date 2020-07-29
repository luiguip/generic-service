package tech.swapy.abstract_service.base_model.persistence;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.persistence.BaseRepository;

@Repository
public interface BaseModelImplRepository<T extends BaseModelImpl, ID extends Serializable> extends BaseRepository<T, ID> {

}
