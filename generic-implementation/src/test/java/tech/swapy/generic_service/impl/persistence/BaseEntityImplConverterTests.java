package tech.swapy.generic_service.impl.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.impl.commons.BaseEntityTestCommons;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;
import tech.swapy.generic_service.persistence.BaseEntityConverter;
import tech.swapy.generic_service.persistency.BaseEntity;

class BaseEntityConverterTests {

	private BaseEntity baseEntity;
	private BaseDomainModelImpl baseDomainModelImpl;
	private List<BaseEntity> baseEntityList;
	private List<BaseDomainModelImpl> baseDomainModelImplList;
	private BaseEntityConverter<BaseEntity, BaseDomainModelImpl> baseEntityConverter = new BaseEntityConverterImpl();

	@BeforeEach
	void init() {
		baseEntity = BaseEntityTestCommons.createBaseEntity();
		baseDomainModelImpl = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseEntityList = BaseEntityTestCommons.createBaseEntityListImpl();
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldPassNotPassNullValues() {
		BaseEntity baseEntityToUpdate = new BaseEntity(null, null, LocalDateTime.now().plusSeconds(1));
		BaseEntity finalBaseEntity = baseEntityConverter.convertUpdate(baseEntity, baseEntityToUpdate);
		assertThat(finalBaseEntity.getId()).isEqualTo(baseEntity.getId());
		assertThat(finalBaseEntity.getCreatedAt()).isEqualTo(baseEntity.getCreatedAt());
		assertThat(finalBaseEntity.getUpdatedAt()).isNotEqualTo(baseEntity.getUpdatedAt());
	}

	@Test
	void shouldBaseEntityHaveSameFieldsOfBaseDomainModelImpl() {
		BaseEntity baseEntity = baseEntityConverter.convert(baseDomainModelImpl);
		checkFields(baseEntity, baseDomainModelImpl);
	}

	@Test
	void shouldBaseDomainModelImplHaveSameFieldsOfBaseEntity() {
		BaseDomainModelImpl baseDomainModelImpl = baseEntityConverter.convert(baseEntity);
		checkFields(baseDomainModelImpl, baseEntity);
	}

	@Test
	void shouldBaseEntityListHaveSameFieldsOfBaseDomainModelImplList() {
		List<BaseEntity> baseEntityList = baseEntityConverter.convertDomainList(baseDomainModelImplList);
		for (int i = 0; i < baseEntityList.size(); i++) {
			checkFields(baseEntityList.get(i), baseDomainModelImplList.get(i));
		}
	}

	@Test
	void shouldBaseDomainModelImplListHaveSameFieldsOfBaseEntityList() {
		List<BaseDomainModelImpl> baseDomainModelImplList = baseEntityConverter
				.convertEntityList(baseEntityList);
		for (int i = 0; i < baseDomainModelImplList.size(); i++) {
			checkFields(baseDomainModelImplList.get(i), baseEntityList.get(i));
		}
	}

	private void checkFields(BaseEntity baseEntity, BaseDomainModelImpl baseDomainModelImpl) {
		assertThat(baseEntity.getId()).isEqualTo(baseDomainModelImpl.getId());
		assertThat(baseEntity.getCreatedAt()).isEqualTo(baseDomainModelImpl.getCreatedAt());
		assertThat(baseEntity.getUpdatedAt()).isEqualTo(baseDomainModelImpl.getUpdatedAt());
	}

	private void checkFields(BaseDomainModelImpl baseDomainModelImpl, BaseEntity baseEntity) {
		assertThat(baseDomainModelImpl.getId()).isEqualTo(baseEntity.getId());
		assertThat(baseDomainModelImpl.getCreatedAt()).isEqualTo(baseEntity.getCreatedAt());
		assertThat(baseDomainModelImpl.getUpdatedAt()).isEqualTo(baseEntity.getUpdatedAt());
	}
}
