package ma.mokhtar.hospital.web;

import ma.mokhtar.hospital.entities.Patient;
import ma.mokhtar.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientRepository.findAll();
    }
}
