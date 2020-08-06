package tech.swapy.generic_service.persistence.spring_data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.swapy.generic_service.domain.BaseDomainModel;
import tech.swapy.generic_service.exceptions.IdNotFoundException;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistence.BaseRepository;
import tech.swapy.generic_service.persistency.BaseEntity;

@Service
@Transactional
public abstract class BaseRepositoryImpl<T extends BaseEntity, E extends BaseDomainModel, ID extends Serializable>
		implements BaseRepository<T, E, ID> {

	@Autowired
	private BaseSpringDataRepository<T, ID> baseSpringDataRepository;

	@Autowired
	private BaseEntityConverter<T, E> baseEntityConverter;

	public BaseRepositoryImpl(BaseSpringDataRepository<T, ID> baseRepository,
			BaseEntityConverter<T, E> baseEntityConverter) {
		this.baseSpringDataRepository = baseRepository;
		this.baseEntityConverter = baseEntityConverter;
	}

	@Override
	public E save(E domainModel) {
		T entity = baseEntityConverter.convert(domainModel);
		T entitySaved = baseSpringDataRepository.save(entity);
		return baseEntityConverter.convert(entitySaved);
	}

	@Override
	public List<E> findAll() {
		List<T> entities = baseSpringDataRepository.findAll();
		return baseEntityConverter.convertEntityList(entities);
	}

	@Override
	public E findById(ID entityId) {
		Optional<T> optionalEntity = baseSpringDataRepository.findById(entityId);
		if (optionalEntity.isPresent()) {
			return baseEntityConverter.convert(optionalEntity.get());
		} else {
			throw new IdNotFoundException("findById");
		}
	}

	@Override
	public E updateById(ID entityId, E domainModel) {
		T entity = baseEntityConverter.convert(domainModel);
		Optional<T> optional = baseSpringDataRepository.findById(entityId);
		if (optional.isPresent()) {
			return baseEntityConverter.convert(baseSpringDataRepository.save(entity));
		} else {
			throw new IdNotFoundException("updateById");
		}
	}

	@Override
	public void deleteById(ID entityId) {
		baseSpringDataRepository.deleteById(entityId);
	}
}