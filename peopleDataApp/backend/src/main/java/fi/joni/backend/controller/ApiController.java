package fi.joni.backend.controller;

import fi.joni.backend.dto.HenkiloDto;
import fi.joni.backend.model.Henkilo;
import fi.joni.backend.service.HenkiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ApiController {

    private final HenkiloService henkiloService;

    @Autowired
    public ApiController(HenkiloService henkiloService) {
        this.henkiloService = henkiloService;
    }

    /**
     * HTTP GET method
     *
     * @return A list of Henkilo objects.
     */
    @GetMapping("/henkilo")
    public List<Henkilo> getHenkiloList() {
        return henkiloService.getHenkiloList();
    }

    /**
     * Create a new Henkilo and add it to the system.
     *
     * This method handles HTTP POST requests to create a new Henkilo.
     *
     * @param request The HenkiloDto object containing the data for the new Henkilo.
     * @return A ResponseEntity with HTTP status 201 (Created) and the newly created Henkilo.
     */
    @PostMapping("/henkilo")
    public ResponseEntity<Henkilo> createHenkilo(@RequestBody HenkiloDto request) {
        Henkilo newHenkilo = new Henkilo();

        newHenkilo.setId(UUID.randomUUID().toString());
        buildHenkiloFromRequest(request, newHenkilo);

        Henkilo henkiloFromService = henkiloService.addHenkilo(newHenkilo);

        return ResponseEntity.status(HttpStatus.CREATED).body(henkiloFromService);
    }

    /**
     * Delete a Henkilo by ID.
     *
     * This method handles HTTP DELETE requests to delete Henkilo.
     *
     * @param id that is unique for Henkilo objects
     * @return A ResponseEntity with HTTP status 204 (no content) if deleted successfully and
     * HTTP status 500 (internal sever error) if some problem has occurred during the process.
     */
    @DeleteMapping("/henkilo/{id}")
    public ResponseEntity<?> deleteHenkilo(@PathVariable String id) {
        try {
            henkiloService.deleteHenkilo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update a Henkilo by ID.
     *
     * This method handles HTTP PUT requests to update a Henkilo's information based on its id.
     *
     * @param id that is unique for Henkilo objects
     * @param request The HenkiloDto containing the updated information.
     * @return A ResponseEntity with HTTP status 200 (OK) and the updated Henkilo if the update was successful,
     * or HTTP status 404 (Not Found) if the Henkilo with the specified ID was not found,
     * or an HTTP status 500 (Internal Server Error) if an exception occurred during the update process.
     */
    @PutMapping("/henkilo/{id}")
    public ResponseEntity<Henkilo> updateHenkilo(@PathVariable String id, @RequestBody HenkiloDto request) {
        try {
            Henkilo newHenkilo = new Henkilo();
            newHenkilo.setId(request.getId());
            buildHenkiloFromRequest(request, newHenkilo);

            Henkilo updatedHenkilo = henkiloService.updateHenkilo(id, newHenkilo);
            if (updatedHenkilo != null) {
                return ResponseEntity.ok(updatedHenkilo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void buildHenkiloFromRequest(@RequestBody HenkiloDto request, Henkilo newHenkilo) {
        newHenkilo.setNimi(request.getNimi());
        newHenkilo.setHenkilotunnus(request.getHenkilotunnus());
        newHenkilo.setOsoitetiedot(request.getOsoitetiedot());
        newHenkilo.setKansalaisuus(request.getKansalaisuus());
        newHenkilo.setAidinkieli(request.getAidinkieli());
        newHenkilo.setPerhesuhdetiedot(request.getPerhesuhdetiedot());
        newHenkilo.setSyntymaJaKuolintiedot(request.getSyntymaJaKuolintiedot());
    }

}
