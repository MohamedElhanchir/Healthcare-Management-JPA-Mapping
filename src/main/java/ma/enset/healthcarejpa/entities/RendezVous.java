package ma.enset.healthcarejpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    /*dans la bdd par défaut quand on stocke un enum on stocke son index
    * mais on peut changer ça en stockant son nom
    * @Enumerated(EnumType.STRING)
     */
    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;

}
