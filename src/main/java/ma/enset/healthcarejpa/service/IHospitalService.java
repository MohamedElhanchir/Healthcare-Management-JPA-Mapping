package ma.enset.healthcarejpa.service;

import ma.enset.healthcarejpa.entities.Consultation;
import ma.enset.healthcarejpa.entities.Medecin;
import ma.enset.healthcarejpa.entities.Patient;
import ma.enset.healthcarejpa.entities.RendezVous;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface IHospitalService {
    Patient savePatient(Patient p);
    Patient findPatientById(Long id);
    Medecin saveMedecin(Medecin m);
    Medecin findMedecinById(Long id);
    RendezVous saveRendezVous(RendezVous r);
    RendezVous findRendezVousById(Long id);
    Consultation saveConsultation(Consultation c);
}
