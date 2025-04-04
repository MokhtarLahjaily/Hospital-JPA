package ma.mokhtar.hospital.service;
import ma.mokhtar.hospital.entities.*;

public interface IHospitalService {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
