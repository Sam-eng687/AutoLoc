package tn.esprit.samarjandoubi4cce10.web.dto;

import lombok.*;
import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehiculeDTO {
    private String immatriculation;
    private String marque;
    private String model;
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private String nomAgence;
}
