package fi.joni.backend.controller;

import fi.joni.backend.dto.HenkiloDto;
import fi.joni.backend.model.Henkilo;
import fi.joni.backend.service.HenkiloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ApiControllerTest {

    private ApiController apiController;
    private HenkiloService henkiloService;

    @BeforeEach
    void setUp() throws Exception {
        henkiloService = Mockito.mock(HenkiloService.class);
        apiController = new ApiController(henkiloService);
    }

    @Test
    void getHenkiloList() {
        // Arrange
        List<Henkilo> henkiloList = new ArrayList<>();
        Henkilo henkilo1 = new Henkilo();
        Henkilo henkilo2 = new Henkilo();
        henkiloList.add(henkilo1);
        henkiloList.add(henkilo2);

        when(henkiloService.getHenkiloList()).thenReturn(henkiloList);

        // Act
        List<Henkilo> result = apiController.getHenkiloList();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void createHenkilo_ReturnsCreatedResponse() {
        // Arrange
        HenkiloDto request = new HenkiloDto();
        request.setNimi("Jaakko");
        Henkilo newHenkilo = new Henkilo();
        newHenkilo.setId(UUID.randomUUID().toString());

        Mockito.when(henkiloService.addHenkilo(Mockito.any(Henkilo.class))).thenReturn(newHenkilo);

        // Act
        ResponseEntity<Henkilo> response = apiController.createHenkilo(request);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newHenkilo, response.getBody());
    }

    @Test
    void deleteHenkilo() {
        // Arrange
        String id = "1";
        Mockito.doNothing().when(henkiloService).deleteHenkilo(id);

        // Act
        ResponseEntity<?> response = apiController.deleteHenkilo(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void updateHenkilo() throws Exception {
        // Arrange
        MockitoAnnotations.openMocks(this);
        HenkiloDto request = new HenkiloDto();
        request.setId("1");

        Henkilo updatedHenkilo = new Henkilo();
        updatedHenkilo.setId("1");

        when(henkiloService.updateHenkilo(eq("1"), any(Henkilo.class))).thenReturn(updatedHenkilo);

        // Act
        ResponseEntity<Henkilo> response = apiController.updateHenkilo(updatedHenkilo.getId(), request);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(updatedHenkilo.getId(), response.getBody().getId());
    }
}
