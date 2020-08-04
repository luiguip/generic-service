package tech.swapy.abstract_service.base.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.persistence.BaseEntity;
import tech.swapy.abstract_service.base.persistence.BaseRepository;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;

@Service
@Transactional
public abstract class BaseServiceImpl<E extends BaseDomainModel, ID extends Serializable> implements BaseService<E, ID> {

	@Autowired
	private BaseRepository baseRepository;

	public BaseServiceImpl(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Override
	public E save(E entity) {
		return (E) baseRepository.save(entity);
	}

	@Override
	public List<E> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public E findById(ID entityId) {
		return (E) baseRepository.findById(entityId);
	}

	@Override
	public E updateById(ID entityId, E entity) {
		return (E) baseRepository.updateById(entity, entityId);
	}

	@Override
	public void deleteById(ID entityId) {
		baseRepository.deleteById(entityId);
	}
}
