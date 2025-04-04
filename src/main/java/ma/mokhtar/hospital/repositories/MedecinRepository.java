package ma.mokhtar.hospital.repositories;

import ma.mokhtar.hospital.entities.Medecin;
import ma.mokhtar.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
