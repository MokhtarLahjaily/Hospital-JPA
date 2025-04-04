package ma.mokhtar.hospital.web;

import ma.mokhtar.hospital.entities.Consultation;
import ma.mokhtar.hospital.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultationRestController {
    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping("/consultations")
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
