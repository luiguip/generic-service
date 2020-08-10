package tech.swapy.generic_service.domain;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.persistence.BaseRepository;

@Service
@Transactional
public abstract class BaseServiceImpl<E extends BaseDomainModel, ID extends Serializable>
		implements BaseService<E, ID> {

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
		return (E) baseRepository.updateById(entityId, entity);
	}

	@Override
	public void deleteById(ID entityId) {
		baseRepository.deleteById(entityId);
	}
}
