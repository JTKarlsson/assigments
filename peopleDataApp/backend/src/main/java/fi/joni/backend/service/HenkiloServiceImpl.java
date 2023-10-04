package fi.joni.backend.service;

import fi.joni.backend.model.Henkilo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HenkiloServiceImpl implements HenkiloService {

    private final List<Henkilo> henkilotietoRekisteri = new ArrayList<>();

    public void getDummyHenkilos() {

        Henkilo henkilo1 = new Henkilo("1","John Doe", "12345", "123 Main St", "US", "English", "Single", "01/01/1980 - 12/31/2099");
        Henkilo henkilo2 = new Henkilo("2","Jane Smith", "67890", "456 Elm St", "CA", "French", "Married", "02/15/1985 - 12/31/2099");
        Henkilo henkilo3 = new Henkilo("3","Jake Black", "67890", "456 Elm St", "CA", "French", "Married", "02/15/1985 - 12/31/2099");

        henkilotietoRekisteri.add(henkilo1);
        henkilotietoRekisteri.add(henkilo2);
        henkilotietoRekisteri.add(henkilo3);
    }

    @Override
    public List<Henkilo> getHenkiloList() {
        return henkilotietoRekisteri;
    }

    @Override
    public Henkilo getHenkiloById(String id) {
        for (Henkilo henkilo : henkilotietoRekisteri) {
            if (henkilo.getId().equals(id)) {
                return henkilo;
            }
        }
        return null; // Henkilo not found
    }

    @Override
    public void addHenkilo(Henkilo henkilo) {
        henkilotietoRekisteri.add(henkilo);
    }

    @Override
    public void updateHenkilo(String id, Henkilo updatedHenkilo) {
        Optional<Henkilo> existingHenkilo = henkilotietoRekisteri.stream()
                .filter(henkilo -> henkilo.getId().equals(id))
                .findFirst();

        if (existingHenkilo.isPresent()) {
            int index = henkilotietoRekisteri.indexOf(existingHenkilo.get());
            henkilotietoRekisteri.set(index, updatedHenkilo);
        } else {
            // Henkilo not found, handle accordingly
        }
    }

    @Override
    public void deleteHenkilo(String id) {
        henkilotietoRekisteri.removeIf(henkilo -> henkilo.getId().equals(id));
    }
}
