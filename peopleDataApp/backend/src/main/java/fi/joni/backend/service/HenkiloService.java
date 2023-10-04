package fi.joni.backend.service;

import fi.joni.backend.model.Henkilo;

import java.util.List;

public interface HenkiloService {

    List<Henkilo> getHenkiloList();

    Henkilo getHenkiloById(String id);

    void addHenkilo(Henkilo henkilo);

    void updateHenkilo(String id, Henkilo updatedHenkilo);

    void deleteHenkilo(String id);
}
