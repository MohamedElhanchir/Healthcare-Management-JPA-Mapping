package ma.enset.healthcarejpa;

import ma.enset.healthcarejpa.entities.*;
import ma.enset.healthcarejpa.repositories.ConsultationRepository;
import ma.enset.healthcarejpa.repositories.MedecinRepository;
import ma.enset.healthcarejpa.repositories.PatientRepository;
import ma.enset.healthcarejpa.repositories.RendezVousRepository;
import ma.enset.healthcarejpa.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

/*
*il y deux façons de faire la commnadlineRunner
* 1- en implementant l'interface CommandLineRunner
* 2- en utilisant l'annotation @Bean
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository
    ) {
        return args -> {


            Stream.of("Hassan", "Khalid", "Omar", "Salma").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random() > 0.5);
                patientRepository.save(patient);
            });

            //création des médecins
            Stream.of("Rachid", "Karim", "Mohamed", "Salma", "Nouhaila").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                medecin.setEmail(name + "@gmail.com");
                medecinRepository.save(medecin);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Medecin medecin = medecinRepository.findById(3L).orElse(null);

            //création de rendez-vous
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVousRepository.save(rendezVous);

            //création d'une consultation
            RendezVous rdv = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rdv);
            consultation.setRapport("Rapport de consultation");
            consultationRepository.save(consultation);


        };
    }*/


    @Bean
    CommandLineRunner start(IHospitalService hospitalService) {
        return args -> {


            Stream.of("Hassan", "Khalid", "Omar", "Salma").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random() > 0.5);
                hospitalService.savePatient(patient);
            });

            //création des médecins
            Stream.of("Rachid", "Karim", "Mohamed", "Salma", "Nouhaila").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                medecin.setEmail(name + "@gmail.com");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = hospitalService.findPatientById(1L);
            Medecin medecin = hospitalService.findMedecinById(3L);

            //création de rendez-vous
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);

            //création d'une consultation
            RendezVous rdv = hospitalService.findRendezVousById(1L);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rdv);
            consultation.setRapport("Rapport de consultation");
            hospitalService.saveConsultation(consultation);


        };
    }
}

