package fi.joni.backend.service;

import fi.joni.backend.model.Henkilo;

import java.util.List;

public interface HenkiloService {

    /**
     * Retrieve a list of Henkilo objects.
     *
     * @return A List of Henkilo objects from henkilotietoRekisteri array.
     */
    List<Henkilo> getHenkiloList();

    /**
     * Add a new Henkilo.
     *
     * This method adds a new Henkilo henkilotietoRekisteri
     *
     * @param henkilo The Henkilo object to be added.
     * @return The added Henkilo object.
     */
    Henkilo addHenkilo(Henkilo henkilo);

    /**
     * Update a Henkilo by ID.
     *
     * This method updates an existing Henkilo's information to the henkilotietoRekisteri.
     *
     * @param id The unique identifier of the Henkilo to be updated.
     * @param updatedHenkilo The Henkilo object containing the updated information.
     * @return The updated Henkilo if the update was successful.
     * @throws Exception If an exception occurs during the update process.
     */
    Henkilo updateHenkilo(String id, Henkilo updatedHenkilo) throws Exception;

    /**
     * Delete a Henkilo by ID.
     *
     * This method deletes a Henkilo based on its id from henkilotietoRekisteri.
     *
     * @param id The unique identifier of the Henkilo to be deleted.
     */
    void deleteHenkilo(String id);
}
