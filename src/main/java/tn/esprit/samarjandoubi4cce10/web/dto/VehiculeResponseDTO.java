package tn.esprit.samarjandoubi4cce10.web.dto;

import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;
import tn.esprit.samarjandoubi4cce10.domain.StatutVehicule;

import java.math.BigDecimal;
import java.util.List;

public record VehiculeResponseDTO(
        Long id,
        String immatriculation,
        String marque,
        String model,
        CategorieVehicule categorie,
        BigDecimal tarifJournalier,
        StatutVehicule statut,
        String agenceNom,
        List<String> equipements
) { }