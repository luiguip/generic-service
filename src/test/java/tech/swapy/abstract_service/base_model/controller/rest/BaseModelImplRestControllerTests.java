package tech.swapy.abstract_service.base_model.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tech.swapy.abstract_service.base.controller.BaseComunicationModelConverter;
import tech.swapy.abstract_service.base.controller.rest.BaseRestController;
import tech.swapy.abstract_service.base.domain.BaseService;
import tech.swapy.abstract_service.base.domain.exceptions.IdNotFoundException;
import tech.swapy.abstract_service.base_model.commons.BaseComunicationModelImplTestCommons;
import tech.swapy.abstract_service.base_model.commons.BaseDomainModelImplTestCommons;
import tech.swapy.abstract_service.base_model.controller.BaseComunicationModelImpl;
import tech.swapy.abstract_service.base_model.domain.BaseDomainModelImpl;

@ExtendWith(MockitoExtension.class)
class BaseModelImplRestControllerTests {

	private BaseComunicationModelImpl baseComunicationModelImplX;
	private BaseComunicationModelImpl baseComunicationModelImplY;
	private List<BaseComunicationModelImpl> baseComunicationModelImplList;
	private BaseDomainModelImpl baseDomainModelImplX;
	private BaseDomainModelImpl baseDomainModelImplY;
	private List<BaseDomainModelImpl> baseDomainModelImplList;

	private BaseRestController<BaseComunicationModelImpl, BaseDomainModelImpl, Long> baseImplRestController;
	@Mock
	private BaseService<BaseDomainModelImpl, Long> baseModelImplService;

	@Mock
	private BaseComunicationModelConverter<BaseComunicationModelImpl, BaseDomainModelImpl> baseComunicationModelImplConverter;

	@BeforeEach
	void init() {
		baseImplRestController = new BaseModelImplRestController(baseModelImplService,
				baseComunicationModelImplConverter);
		baseComunicationModelImplX = BaseComunicationModelImplTestCommons.createBaseComunicationModelImpl();
		baseComunicationModelImplY = BaseComunicationModelImplTestCommons
				.cloneBaseComunicationModelImpl(baseComunicationModelImplX);
		baseComunicationModelImplList = BaseComunicationModelImplTestCommons.createBaseComunicationModelImplListl();
		baseDomainModelImplX = BaseDomainModelImplTestCommons.createBaseDomainModelImpl();
		baseDomainModelImplY = BaseDomainModelImplTestCommons.cloneBaseDomainModelImpl(baseDomainModelImplX);
		baseDomainModelImplList = BaseDomainModelImplTestCommons.createBaseDomainModelListImpl();
	}

	@Test
	void shouldSave() {
		baseComunicationModelImplY.setId(null);
		baseDomainModelImplY.setId(null);
		lenient().when(baseComunicationModelImplConverter.convert(baseComunicationModelImplY))
				.thenReturn(baseDomainModelImplY);
		lenient().when(baseModelImplService.save(baseDomainModelImplY)).thenReturn(baseDomainModelImplX);
		lenient().when(baseComunicationModelImplConverter.convert(baseDomainModelImplX))
				.thenReturn(baseComunicationModelImplX);
		assertThat(baseImplRestController.save(baseComunicationModelImplY)).isEqualTo(baseComunicationModelImplX);
	}

	@Test
	void shouldFindAll() {
		lenient().when(baseModelImplService.findAll()).thenReturn(baseDomainModelImplList);
		lenient().when(baseComunicationModelImplConverter.convertDomainList(baseDomainModelImplList))
				.thenReturn(baseComunicationModelImplList);
		assertThat(baseImplRestController.findAll()).isEqualTo(baseComunicationModelImplList);
	}

	@Test
	void shouldFindById() throws IdNotFoundException {
		lenient().when(baseModelImplService.findById(1L)).thenReturn(baseDomainModelImplX);
		lenient().when(baseComunicationModelImplConverter.convert(baseDomainModelImplX))
				.thenReturn(baseComunicationModelImplX);
		assertThat(baseImplRestController.findById(1L)).isEqualTo(baseComunicationModelImplX);
	}

	@Test
	void shouldNotFindById() throws IdNotFoundException {
		lenient().when(baseModelImplService.findById(1L)).thenThrow(new IdNotFoundException("findById"));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseImplRestController.findById(1L);
		});
		String expectedMessage = "findById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldUpdateById() throws IdNotFoundException {
		lenient().when(baseComunicationModelImplConverter.convert(baseComunicationModelImplX))
				.thenReturn(baseDomainModelImplX);
		lenient().when(baseModelImplService.updateById(1L, baseDomainModelImplY)).thenReturn(baseDomainModelImplX);
		lenient().when(baseComunicationModelImplConverter.convert(baseDomainModelImplX))
				.thenReturn(baseComunicationModelImplX);
		assertThat(baseImplRestController.updateById(1L, baseComunicationModelImplX))
				.isEqualTo(baseComunicationModelImplX);
	}

	@Test
	void shouldNotUpdateById() throws IdNotFoundException {
		lenient().when(baseComunicationModelImplConverter.convert(baseComunicationModelImplX))
		.thenReturn(baseDomainModelImplX);
		lenient().when(baseModelImplService.updateById(1L, baseDomainModelImplX))
				.thenThrow(new IdNotFoundException("updateById"));
		IdNotFoundException idNotFoundException = assertThrows(IdNotFoundException.class, () -> {
			baseImplRestController.updateById(1L, baseComunicationModelImplX);
		});
		String expectedMessage = "updateById";
		assertEquals(expectedMessage, idNotFoundException.getMessage());
	}

	@Test
	void shouldDeleteById() {
		assertDoesNotThrow(() -> baseImplRestController.deleteById(1L));
	}
}
