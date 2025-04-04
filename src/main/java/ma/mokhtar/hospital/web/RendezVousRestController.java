package ma.mokhtar.hospital.web;

import ma.mokhtar.hospital.entities.RendezVous;
import ma.mokhtar.hospital.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RendezVousRestController {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @GetMapping("/rendezvous")
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }
}
