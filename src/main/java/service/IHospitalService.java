package service;

import ma.enset.healthcarejpa.entities.Consultation;
import ma.enset.healthcarejpa.entities.Medecin;
import ma.enset.healthcarejpa.entities.Patient;
import ma.enset.healthcarejpa.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
