package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule v);

    Vehicule findById(Long id);

    List<VehiculeDTO> findAll();
    VehiculeDTO toDTO (Vehicule vehicule);

    void deleteById(Long id);

    Vehicule update(Vehicule vehicule);

    Vehicule assignAgence(Long idVehicule, Long idAgence);
    Vehicule assignEquipement (Long idVehicule, Long idEquipement);
    void unassignEquipement (Long idVehicule, Long idEquipement);
    Vehicule addAndAssignAgence (Vehicule vehicule, Long idAgence);
}
