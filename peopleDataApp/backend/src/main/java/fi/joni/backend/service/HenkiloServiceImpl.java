package fi.joni.backend.service;

import fi.joni.backend.model.Henkilo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HenkiloServiceImpl implements HenkiloService {

    private final List<Henkilo> henkilotietoRekisteri = new ArrayList<>();

    @Override
    public List<Henkilo> getHenkiloList() {
        return henkilotietoRekisteri;
    }

    @Override
    public Henkilo addHenkilo(Henkilo henkilo) {
        henkilotietoRekisteri.add(henkilo);
        return henkilo;
    }

    @Override
    public Henkilo updateHenkilo(String id, Henkilo updatedHenkilo) throws Exception {
        Optional<Henkilo> existingHenkilo = henkilotietoRekisteri.stream()
                .filter(henkilo -> henkilo.getId().equals(id))
                .findFirst();

        if (existingHenkilo.isPresent()) {
            int index = henkilotietoRekisteri.indexOf(existingHenkilo.get());
            henkilotietoRekisteri.set(index, updatedHenkilo);
        } else {
            //Should not happen
            throw new Exception("Henkilo is not found");
        }
        return updatedHenkilo;
    }

    @Override
    public void deleteHenkilo(String id) {
        henkilotietoRekisteri.removeIf(henkilo -> henkilo.getId().equals(id));
    }

}
