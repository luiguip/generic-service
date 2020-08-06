package tech.swapy.generic_service.impl.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.swapy.generic_service.controller.BaseComunicationModelConverter;
import tech.swapy.generic_service.impl.commons.BaseComunicationModelImplTestCommons;
import tech.swapy.generic_service.impl.commons.BaseDomainModelImplTestCommons;
import tech.swapy.generic_service.impl.domain.BaseDomainModelImpl;

class BaseComunicationModelImplConverterTests {

	private BaseComunicationModelImpl baseComunicationModelImpl;
	private BaseDomainModelImpl baseDomainModelImpl;
	private List<BaseComunicationModelImpl> baseComunicationModelImplList;
	private List<BaseDomainModelImpl> baseDomainModelImplList;
	private BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelImplConverter = new BaseComunicationModelmplConverter();

	@BeforeEach
	void init() {
		baseComunicationModelImpl = BaseComunicationModelImplTestCommons.createBaseComunicationModelImpl();
		baseDomainModelImpl = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseComunicationModelImplList = BaseComunicationModelImplTestCommons.createBaseComunicationModelImplListl();
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldBaseComunicationModelImplHaveSameFieldsOfBaseDomainModelImpl() {
		BaseComunicationModelImpl baseComunicationModelImpl = baseComunicationModelImplConverter
				.convert(baseDomainModelImpl);
		checkFields(baseComunicationModelImpl, baseDomainModelImpl);
	}

	@Test
	void shouldBaseDomainModelImplHaveSameFieldsOfBaseComunicationModelImpl() {
		BaseDomainModelImpl baseDomainModelImpl = baseComunicationModelImplConverter.convert(baseComunicationModelImpl);
		checkFields(baseDomainModelImpl, baseComunicationModelImpl);
	}

	@Test
	void shouldBaseComunicationModelImplListHaveSameFieldsOfBaseDomainModelImplList() {
		List<BaseComunicationModelImpl> baseComunicationModelImplList = baseComunicationModelImplConverter
				.convertDomainList(baseDomainModelImplList);
		for (int i = 0; i < baseComunicationModelImplList.size(); i++) {
			checkFields(baseComunicationModelImplList.get(i), baseDomainModelImplList.get(i));
		}
	}

	@Test
	void shouldBaseDomainModelImplListHaveSameFieldsOfBaseComunicationModelImplList() {
		List<BaseDomainModelImpl> baseDomainModelImplList = baseComunicationModelImplConverter
				.convertComunicationModelList(baseComunicationModelImplList);
		for (int i = 0; i < baseDomainModelImplList.size(); i++) {
			checkFields(baseDomainModelImplList.get(i), baseComunicationModelImplList.get(i));
		}
	}

	private void checkFields(BaseComunicationModelImpl baseComunicationModelImpl,
			BaseDomainModelImpl baseDomainModelImpl) {
		assertThat(baseComunicationModelImpl.getId()).isEqualTo(baseDomainModelImpl.getId());
		assertThat(baseComunicationModelImpl.getCreatedAt()).isEqualTo(baseDomainModelImpl.getCreatedAt());
		assertThat(baseComunicationModelImpl.getUpdatedAt()).isEqualTo(baseDomainModelImpl.getUpdatedAt());
	}

	private void checkFields(BaseDomainModelImpl baseDomainModelImpl,
			BaseComunicationModelImpl baseComunicationModelImpl) {
		assertThat(baseDomainModelImpl.getId()).isEqualTo(baseComunicationModelImpl.getId());
		assertThat(baseDomainModelImpl.getCreatedAt()).isEqualTo(baseComunicationModelImpl.getCreatedAt());
		assertThat(baseDomainModelImpl.getUpdatedAt()).isEqualTo(baseComunicationModelImpl.getUpdatedAt());
	}
}
