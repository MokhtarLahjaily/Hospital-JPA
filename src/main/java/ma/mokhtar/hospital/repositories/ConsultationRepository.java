package ma.mokhtar.hospital.repositories;

import ma.mokhtar.hospital.entities.Consultation;
import ma.mokhtar.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
