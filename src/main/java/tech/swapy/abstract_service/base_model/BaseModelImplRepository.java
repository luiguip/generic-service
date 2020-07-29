package tech.swapy.abstract_service.base_model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.BaseRepository;

@Repository
public interface BaseModelImplRepository<T extends BaseModelImpl, ID extends Serializable> extends BaseRepository<T, ID> {

}
