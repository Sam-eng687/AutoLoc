package tn.esprit.samarjandoubi4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idReservation;
    LocalDate dateDebut;
    LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    StatutReservation statut;
    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne
    private Client client;
    @OneToOne (mappedBy = "reservation")
    private Contrat contrat;
}
