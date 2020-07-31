package tech.swapy.abstract_service.base.persistence.spring_data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tech.swapy.abstract_service.base.domain.BaseDomainModel;
import tech.swapy.abstract_service.base.persistence.BaseEntity;
import tech.swapy.abstract_service.base.persistence.BaseEntityConverter;
import tech.swapy.abstract_service.base.persistence.BaseRepository;

@Repository
@Transactional
public abstract class BaseRepositoryImpl<T extends BaseEntity, E extends BaseDomainModel, ID extends Serializable> implements BaseRepository<T, E, ID> {

	@Autowired
	private BaseSpringDataRepository<T, ID> baseRepository;
	
	@Autowired
	private BaseEntityConverter<T, E> baseEntityConverter;

	public BaseRepositoryImpl(BaseSpringDataRepository<T, ID> baseRepository, BaseEntityConverter<T, E> baseEntityConverter) {
		this.baseRepository = baseRepository;
		this.baseEntityConverter = baseEntityConverter;
	}

	@Override
	public E save(E domainModel) {
		T entity = baseEntityConverter.convert(domainModel);
		T entitySaved = baseRepository.save(entity);
		return baseEntityConverter.convert(entitySaved);
	}

	@Override
	public List<E> findAll() {
		List<T> entities = baseRepository.findAll();
		return baseEntityConverter.convertEntityList(entities);
	}

	@Override
	public E findById(ID entityId) {
		Optional<T> optionalEntity = baseRepository.findById(entityId);
		if(optionalEntity.isPresent()) {
			return baseEntityConverter.convert(optionalEntity.get());
		} else {
			return null;
		}
	}

	@Override
	public E updateById(E domainModel, ID entityId) {
		T entity = baseEntityConverter.convert(domainModel);
		Optional<T> optional = baseRepository.findById(entityId);
		if (optional.isPresent()) {
			return baseEntityConverter.convert(baseRepository.save(entity));
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(ID entityId) {
		baseRepository.deleteById(entityId);
	}
}