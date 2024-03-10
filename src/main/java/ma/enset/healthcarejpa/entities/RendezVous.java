package ma.enset.healthcarejpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    /*
    * c'est pratique de mettre l'id de type String
    * car Long peut avoir une limite
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    /*dans la bdd par défaut quand on stocke un enum on stocke son index
    * mais on peut changer ça en stockant son nom
    * @Enumerated(EnumType.STRING)
     */
    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    /*
    *access = JsonProperty.Access.READ_WRITE
    * car si on veut récupérer le patient on va tourner en boucle infinie
    * car le patient a un rendez-vous et le rendez-vous a un patient
     */
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;

}
