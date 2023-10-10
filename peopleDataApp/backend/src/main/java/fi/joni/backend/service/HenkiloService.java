package fi.joni.backend.service;

import fi.joni.backend.model.Henkilo;

import java.util.List;

public interface HenkiloService {

    List<Henkilo> getHenkiloList();

    Henkilo addHenkilo(Henkilo henkilo);

    Henkilo updateHenkilo(String id, Henkilo updatedHenkilo) throws Exception;

    void deleteHenkilo(String id);
}
