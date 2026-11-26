package tn.esprit.samarjandoubi4cce10.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;

import java.math.BigDecimal;

public record VehiculeRequestDTO(
        @NotBlank(message = "L'immatriculation est obligatoire")
        @Pattern(regexp = "^\\d{1,3}TU\\d{1,4}$", message = "Format attendu : 120TU1001")
        String immatriculation,

        @NotBlank(message = "La marque est obligatoire")
        @Size(max = 30, message = "30 caractères maximum")
        String marque,

        @NotBlank(message = "Le modèle est obligatoire")
        @Size(max = 30, message = "30 caractères maximum")
        String model,

        @NotNull(message = "La catégorie est obligatoire")
        CategorieVehicule categorie,

        @NotNull(message = "Le tarif est obligatoire")
        @Positive(message = "Le tarif doit être strictement positif")
        BigDecimal tarifJournalier,

        @NotNull(message = "L'agence est obligatoire")
        Long agenceId
) { }