package fi.joni.backend.controller;

import fi.joni.backend.model.Henkilo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/henkilo")
public class ApiController {

    @GetMapping("/")
    public List<Henkilo> getDummyHenkilos() {
        List<Henkilo> dummyHenkilos = new ArrayList<>();

        Henkilo henkilo1 = new Henkilo("John Doe", "12345", "123 Main St", "US", "English", "Single", "01/01/1980 - 12/31/2099");
        Henkilo henkilo2 = new Henkilo("Jane Smith", "67890", "456 Elm St", "CA", "French", "Married", "02/15/1985 - 12/31/2099");

        dummyHenkilos.add(henkilo1);
        dummyHenkilos.add(henkilo2);

        return dummyHenkilos;

    }
}