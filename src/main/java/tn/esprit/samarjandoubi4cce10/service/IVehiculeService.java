package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;
import tn.esprit.samarjandoubi4cce10.domain.StatutVehicule;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.web.dto.NbVehiculesAgenceDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeRequestDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResponseDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResumeDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IVehiculeService {

    VehiculeResponseDTO create(VehiculeRequestDTO dto);
    VehiculeResponseDTO findById(Long id);
    List<VehiculeResumeDTO> findAll();
    void deleteById(Long id);
    Vehicule update(Vehicule vehicule);
    VehiculeResponseDTO assignAgence(Long idVehicule, Long idAgence);
    VehiculeResponseDTO assignEquipement(Long idVehicule, Long idEquipement);
    void unassignEquipement(Long idVehicule, Long idEquipement);

    List<VehiculeResumeDTO> findByMarque(String marque);
    List<VehiculeResumeDTO> findByCategorieAndStatut(CategorieVehicule categorie, StatutVehicule statut);
    List<VehiculeResumeDTO> findByTarif(BigDecimal min, BigDecimal max);
    List<VehiculeResumeDTO> findByModel(String motCle);
    List<VehiculeResumeDTO> findByCategories(List<CategorieVehicule> categories);
    boolean existsByImmatriculation(String immatriculation);
    long countByStatut(StatutVehicule statut);
    List<VehiculeResumeDTO> findTroisMoinsChers();
    List<VehiculeResumeDTO> findByAgence(Long agenceId);
    List<VehiculeResumeDTO> findSansAgence();

    List<VehiculeResumeDTO> findByVilleAgence(String ville);
    List<VehiculeResumeDTO> findByEquipement(String libelle);
    List<VehiculeResumeDTO> findAvecAuMoinsNEquipements(long n);
    List<VehiculeResumeDTO> findReservesParClient(Long clientId);
    List<VehiculeResumeDTO> findJamaisReserves();
    List<VehiculeResumeDTO> findEnMaintenanceLe(LocalDate date);
    List<NbVehiculesAgenceDTO> compterParAgence();
}