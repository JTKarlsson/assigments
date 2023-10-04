package fi.joni.backend.controller;

import fi.joni.backend.dto.HenkiloDto;
import fi.joni.backend.model.Henkilo;
import fi.joni.backend.service.HenkiloService;
import fi.joni.backend.service.HenkiloServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
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
    public ApiController(HenkiloServiceImpl henkiloServiceImpl) {
        this.henkiloService = henkiloServiceImpl;
    }

    @GetMapping("/henkilo")
    public List<Henkilo> getDummyHenkilos() {
        return henkiloService.getHenkiloList();
    }
    @PostMapping("/henkilo")
    public ResponseEntity<String> createHenkilo(@RequestBody HenkiloDto request) {
        Henkilo newHenkilo = new Henkilo();

        newHenkilo.setId(UUID.randomUUID().toString());
        newHenkilo.setNimi(request.getNimi());

        henkiloService.addHenkilo(newHenkilo);

        return ResponseEntity.status(HttpStatus.CREATED).body("Henkilo created successfully");
    }
}
