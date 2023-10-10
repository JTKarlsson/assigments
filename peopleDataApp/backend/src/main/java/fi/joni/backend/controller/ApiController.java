package fi.joni.backend.controller;

import fi.joni.backend.dto.HenkiloDto;
import fi.joni.backend.model.Henkilo;
import fi.joni.backend.service.HenkiloService;
import fi.joni.backend.service.HenkiloServiceImpl;
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

    @GetMapping("/henkilo")
    public List<Henkilo> getHenkiloList() {
        return henkiloService.getHenkiloList();
    }

    @PostMapping("/henkilo")
    public ResponseEntity<Henkilo> createHenkilo(@RequestBody HenkiloDto request) {
        Henkilo newHenkilo = new Henkilo();

        newHenkilo.setId(UUID.randomUUID().toString());
        buildHenkiloFromRequest(request, newHenkilo);

        Henkilo henkiloFromService = henkiloService.addHenkilo(newHenkilo);

        return ResponseEntity.status(HttpStatus.CREATED).body(henkiloFromService);
    }

    @DeleteMapping("/henkilo/{id}")
    public ResponseEntity<?> deleteHenkilo(@PathVariable String id) {
        try {
            henkiloService.deleteHenkilo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

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
