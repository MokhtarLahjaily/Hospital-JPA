package ma.mokhtar.hospital.service;



import ma.mokhtar.hospital.entities.*;
import ma.mokhtar.hospital.repositories.*;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(
            PatientRepository patientRepository, MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {
        r.setId( UUID.randomUUID().toString());
        return rendezVousRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }
}
