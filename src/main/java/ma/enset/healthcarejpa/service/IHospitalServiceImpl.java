package ma.enset.healthcarejpa.service;

import jakarta.transaction.Transactional;
import ma.enset.healthcarejpa.entities.Consultation;
import ma.enset.healthcarejpa.entities.Medecin;
import ma.enset.healthcarejpa.entities.Patient;
import ma.enset.healthcarejpa.entities.RendezVous;
import ma.enset.healthcarejpa.repositories.ConsultationRepository;
import ma.enset.healthcarejpa.repositories.MedecinRepository;
import ma.enset.healthcarejpa.repositories.PatientRepository;
import ma.enset.healthcarejpa.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    /*
    * @Autowired
    * PatientRepository patientRepository;
    * @Autowired
    * MedecinRepository medecinRepository;
    * @Autowired
    * RendezVousRepository rendezVousRepository;
    * @Autowired
    * ConsultationRepository consultationRepository;
    * On peut aussi utiliser le constructeur pour injecter les dépendances
     */
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
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
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
            return medecinRepository.save(m);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {
        return rendezVousRepository.save(r);
    }

    @Override
    public RendezVous findRendezVousById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
            return consultationRepository.save(c);
    }
}
