package ma.mokhtar.hospital.repositories;

import ma.mokhtar.hospital.entities.Patient;
import ma.mokhtar.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
