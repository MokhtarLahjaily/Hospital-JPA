package ma.mokhtar.hospital;

import ma.mokhtar.hospital.entities.*;
import ma.mokhtar.hospital.repositories.ConsultationRepository;
import ma.mokhtar.hospital.repositories.MedecinRepository;
import ma.mokhtar.hospital.repositories.PatientRepository;
import ma.mokhtar.hospital.repositories.RendezVousRepository;
import ma.mokhtar.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Mohamed", "Hassan", "Mokhtar")
                    .forEach(name -> {

                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
            });
            Stream.of("ayman", "hanane", "yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name + "@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologie" : "Neurologie");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient2 = patientRepository.findByNom("Mohamed");
            Medecin medecin = medecinRepository.findByNom("yasmine");

            RendezVous rendezVous= new RendezVous();
            rendezVous.setDateRdv(new Date());
            rendezVous.setStatusRdv(StatusRdv.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous saveDRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println(saveDRDV.getId());
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1= rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Tout va bien");
            hospitalService.saveConsultation(consultation);

        };

    }

}
