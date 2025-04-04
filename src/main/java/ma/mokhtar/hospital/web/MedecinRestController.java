package ma.mokhtar.hospital.web;

import ma.mokhtar.hospital.entities.Medecin;
import ma.mokhtar.hospital.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedecinRestController {
    @Autowired
    private MedecinRepository medecinRepository;

    // Add methods to handle HTTP requests for Medecin entities
    // For example, you can add methods to create, read, update, and delete Medecin entities
    // Example method to get all Medecin entities
     @GetMapping("/medecins")
     public List<Medecin> getAllMedecins() {
         return medecinRepository.findAll();
     }

}
