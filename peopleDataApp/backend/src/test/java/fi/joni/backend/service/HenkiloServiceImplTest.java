package fi.joni.backend.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import fi.joni.backend.model.Henkilo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HenkiloServiceImplTest {

    private HenkiloServiceImpl henkiloService;

    @BeforeEach
    void setUp() {
        henkiloService = new HenkiloServiceImpl();
    }

    @Test
    void getHenkiloList() {
        // Arrange
        Henkilo henkilo1 = new Henkilo();
        henkilo1.setId("1");
        henkilo1.setNimi("Pertti");

        Henkilo henkilo2 = new Henkilo();
        henkilo2.setId("2");
        henkilo2.setNimi("Maija");

        henkiloService.addHenkilo(henkilo1);
        henkiloService.addHenkilo(henkilo2);

        // Act
        List<Henkilo> result = henkiloService.getHenkiloList();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Pertti", result.get(0).getNimi());
        assertEquals("Maija", result.get(1).getNimi());
    }



    @Test
    void addHenkilo() {
        // Arrange
        Henkilo henkilo = new Henkilo();
        henkilo.setId("1");
        henkilo.setNimi("Pertti");

        // Act
        henkiloService.addHenkilo(henkilo);

        // Assert
        assertEquals(1, henkiloService.getHenkiloList().size());
        assertEquals("Pertti", henkiloService.getHenkiloList().get(0).getNimi());
    }

    @Test
    void updateHenkilo() throws Exception {
        // Arrange
        Henkilo existingHenkilo = new Henkilo();
        existingHenkilo.setId("1");
        existingHenkilo.setNimi("Pertti");

        Henkilo updatedHenkilo = new Henkilo();
        updatedHenkilo.setId("1");
        updatedHenkilo.setNimi("Updated Pertti");

        henkiloService.addHenkilo(existingHenkilo);

        // Act
        Henkilo result = henkiloService.updateHenkilo("1", updatedHenkilo);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Pertti", result.getNimi());
    }

    @Test
    void deleteHenkilo() {
        // Arrange
        Henkilo henkilo1 = new Henkilo();
        henkilo1.setId("1");
        henkilo1.setNimi("Pertti");

        Henkilo henkilo2 = new Henkilo();
        henkilo2.setId("2");
        henkilo2.setNimi("Maija");

        henkiloService.addHenkilo(henkilo1);
        henkiloService.addHenkilo(henkilo2);

        // Act
        henkiloService.deleteHenkilo("1");

        // Assert
        assertEquals(1, henkiloService.getHenkiloList().size());
        assertFalse(henkiloService.getHenkiloList().stream().anyMatch(henkilo -> henkilo.getId().equals("1")));
    }
}
