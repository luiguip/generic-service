package tech.swapy.abstract_service.base_model.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.abstract_service.base.persistence.BaseEntityConverter;
import tech.swapy.abstract_service.base_model.commons.BaseDomainModelImplTestCommons;
import tech.swapy.abstract_service.base_model.commons.BaseEntityImplTestCommons;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

class BaseEntityImplConverterTests {

	private BaseEntityImpl baseEntityImpl;
	private BaseDomainModelImpl baseDomainModelImpl;
	private List<BaseEntityImpl> baseEntityImplList;
	private List<BaseDomainModelImpl> baseDomainModelImplList;
	private BaseEntityConverter<BaseEntityImpl, BaseDomainModelImpl> baseEntityImplConverter = new BaseEntityImplConverter();

	@BeforeEach
	void init() {
		baseEntityImpl = BaseEntityImplTestCommons.createBaseEntityImpl();
		baseDomainModelImpl = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseEntityImplList = BaseEntityImplTestCommons.createBaseEntityListImpl();
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}
	
	@Test
	void shouldBaseEntityImplHaveSameFieldsOfBaseDomainModelImpl() {
		BaseEntityImpl baseEntityImpl = baseEntityImplConverter.convert(baseDomainModelImpl);
		checkFields(baseEntityImpl, baseDomainModelImpl);
	}
	
	@Test
	void shouldBaseDomainModelImplHaveSameFieldsOfBaseEntityImpl() {
		BaseDomainModelImpl baseDomainModelImpl = baseEntityImplConverter.convert(baseEntityImpl);
		checkFields(baseDomainModelImpl, baseEntityImpl);
	}
	
	@Test
	void shouldBaseEntityImplListHaveSameFieldsOfBaseDomainModelImplList() {
		List<BaseEntityImpl> baseEntityImplList = baseEntityImplConverter.convertDomainList(baseDomainModelImplList);
		for(int i = 0 ; i < baseEntityImplList.size() ; i++) {
			checkFields(baseEntityImplList.get(i), baseDomainModelImplList.get(i));
		}
	}
	
	@Test
	void shouldBaseDomainModelImplListHaveSameFieldsOfBaseEntityImplList() {
		List<BaseDomainModelImpl> baseDomainModelImplList = baseEntityImplConverter.convertEntityList(baseEntityImplList);
		for(int i = 0 ; i < baseDomainModelImplList.size() ; i++) {
			checkFields(baseDomainModelImplList.get(i), baseEntityImplList.get(i));
		}
	}
	
	private void checkFields(BaseEntityImpl baseEntityImpl, BaseDomainModelImpl baseDomainModelImpl) {
		assertThat(baseEntityImpl.getId()).isEqualTo(baseDomainModelImpl.getId());
		assertThat(baseEntityImpl.getCreatedAt()).isEqualTo(baseDomainModelImpl.getCreatedAt());
		assertThat(baseEntityImpl.getUpdatedAt()).isEqualTo(baseDomainModelImpl.getUpdatedAt());
	}

	private void checkFields(BaseDomainModelImpl baseDomainModelImpl, BaseEntityImpl baseEntityImpl) {
		assertThat(baseDomainModelImpl.getId()).isEqualTo(baseEntityImpl.getId());
		assertThat(baseDomainModelImpl.getCreatedAt()).isEqualTo(baseEntityImpl.getCreatedAt());
		assertThat(baseDomainModelImpl.getUpdatedAt()).isEqualTo(baseEntityImpl.getUpdatedAt());
	}
}
