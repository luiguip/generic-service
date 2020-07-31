package tech.swapy.abstract_service.base.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.swapy.abstract_service.base.persistence.BaseEntity;
import tech.swapy.abstract_service.base.persistence.spring_data.BaseSpringDataRepository;

@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;

	public BaseServiceImpl(BaseSpringDataRepository<T, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Override
	public T save(T entity) {
		return (T) baseRepository.save(entity);
	}

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public Optional<T> findById(ID entityId) {
		return baseRepository.findById(entityId);
	}

	@Override
	public T update(T entity) {
		return (T) baseRepository.save(entity);
	}

	@Override
	public T updateById(T entity, ID entityId) {
		Optional<T> optional = baseRepository.findById(entityId);
		if (optional.isPresent()) {
			return (T) baseRepository.save(entity);
		} else {
			return null;
		}
	}

	@Override
	public void delete(T entity) {
		baseRepository.delete(entity);
	}

	@Override
	public void deleteById(ID entityId) {
		baseRepository.deleteById(entityId);
	}
}
