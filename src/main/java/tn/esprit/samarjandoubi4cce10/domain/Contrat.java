package tn.esprit.samarjandoubi4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;
    LocalDate dateSignature;
    BigDecimal montantTotal;
    boolean valide;

    @OneToOne (mappedBy = "contrat")
    private Reservation reservation;

    @OneToOne (fetch = FetchType.LAZY)
    Reservation res;



    @OneToMany (mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    Set<Paiement> paiements= new HashSet<>();
}
