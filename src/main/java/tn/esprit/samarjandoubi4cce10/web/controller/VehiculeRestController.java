package tn.esprit.samarjandoubi4cce10.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;
import tn.esprit.samarjandoubi4cce10.domain.StatutVehicule;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.service.IVehiculeService;
import tn.esprit.samarjandoubi4cce10.web.dto.NbVehiculesAgenceDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeRequestDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResponseDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResumeDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Vehicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;


    @PostMapping
    public ResponseEntity<VehiculeResponseDTO> add(@Valid @RequestBody VehiculeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.create(dto));
    }

    @GetMapping("{id}")
    public VehiculeResponseDTO getVehicule(@PathVariable Long id) {
        return vehiculeService.findById(id);
    }

    @GetMapping
    public List<VehiculeResumeDTO> findAll() {
        return vehiculeService.findAll();
    }

    @PutMapping
    public Vehicule update(@RequestBody Vehicule v) {
        return vehiculeService.update(v);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        vehiculeService.deleteById(id);
    }


    @PutMapping("{idVehicule}/agences/{idAgence}")
    public VehiculeResponseDTO assignAgence(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return vehiculeService.assignAgence(idVehicule, idAgence);
    }

    @PutMapping("{idVehicule}/equipements/{idEquipement}")
    public VehiculeResponseDTO assignEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.assignEquipement(idVehicule, idEquipement);
    }

    @DeleteMapping("{idVehicule}/equipements/{idEquipement}")
    public void unassignEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        vehiculeService.unassignEquipement(idVehicule, idEquipement);
    }


    @GetMapping("/recherche/marque/{marque}")
    public List<VehiculeResumeDTO> findByMarque(@PathVariable String marque) {
        return vehiculeService.findByMarque(marque);
    }

    @GetMapping("/recherche/categorie/{categorie}/statut/{statut}")
    public List<VehiculeResumeDTO> findByCategorieAndStatut(@PathVariable CategorieVehicule categorie,
                                                            @PathVariable StatutVehicule statut) {
        return vehiculeService.findByCategorieAndStatut(categorie, statut);
    }

    @GetMapping("/recherche/tarif/{min}/{max}")
    public List<VehiculeResumeDTO> findByTarif(@PathVariable BigDecimal min, @PathVariable BigDecimal max) {
        return vehiculeService.findByTarif(min, max);
    }

    @GetMapping("/recherche/model/{motCle}")
    public List<VehiculeResumeDTO> findByModel(@PathVariable String motCle) {
        return vehiculeService.findByModel(motCle);
    }

    @GetMapping("/recherche/categories/{categories}")
    public List<VehiculeResumeDTO> findByCategories(@PathVariable List<CategorieVehicule> categories) {
        return vehiculeService.findByCategories(categories);
    }

    @GetMapping("/recherche/existe/{immatriculation}")
    public boolean existsByImmatriculation(@PathVariable String immatriculation) {
        return vehiculeService.existsByImmatriculation(immatriculation);
    }

    @GetMapping("/recherche/count/{statut}")
    public long countByStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.countByStatut(statut);
    }

    @GetMapping("/recherche/moins-chers")
    public List<VehiculeResumeDTO> findTroisMoinsChers() {
        return vehiculeService.findTroisMoinsChers();
    }

    @GetMapping("/recherche/agence/{agenceId}")
    public List<VehiculeResumeDTO> findByAgence(@PathVariable Long agenceId) {
        return vehiculeService.findByAgence(agenceId);
    }

    @GetMapping("/recherche/sans-agence")
    public List<VehiculeResumeDTO> findSansAgence() {
        return vehiculeService.findSansAgence();
    }


    @GetMapping("/ville/{ville}")
    public List<VehiculeResumeDTO> findByVille(@PathVariable String ville) {
        return vehiculeService.findByVilleAgence(ville);
    }

    @GetMapping("/equipement/{libelle}")
    public List<VehiculeResumeDTO> findByEquipement(@PathVariable String libelle) {
        return vehiculeService.findByEquipement(libelle);
    }

    @GetMapping("/equipements/minimum/{n}")
    public List<VehiculeResumeDTO> findAvecAuMoinsNEquipements(@PathVariable long n) {
        return vehiculeService.findAvecAuMoinsNEquipements(n);
    }

    @GetMapping("/client/{clientId}")
    public List<VehiculeResumeDTO> findReservesParClient(@PathVariable Long clientId) {
        return vehiculeService.findReservesParClient(clientId);
    }

    @GetMapping("/jamais-reserves")
    public List<VehiculeResumeDTO> findJamaisReserves() {
        return vehiculeService.findJamaisReserves();
    }

    @GetMapping("/maintenance/{date}")
    public List<VehiculeResumeDTO> findEnMaintenanceLe(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return vehiculeService.findEnMaintenanceLe(date);
    }

    @GetMapping("/stats/par-agence")
    public List<NbVehiculesAgenceDTO> compterParAgence() {
        return vehiculeService.compterParAgence();
    }
}