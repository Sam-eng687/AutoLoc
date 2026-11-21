package tn.esprit.samarjandoubi4cce10.service.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Agence;
import tn.esprit.samarjandoubi4cce10.domain.Equipement;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.repository.IAgenceRepository;
import tn.esprit.samarjandoubi4cce10.repository.IEquipementRepository;
import tn.esprit.samarjandoubi4cce10.repository.IVehiculeRepository;
import tn.esprit.samarjandoubi4cce10.service.IEquipementService;
import tn.esprit.samarjandoubi4cce10.service.IVehiculeService;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeDTO;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor


public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final IEquipementRepository equipementRepository;


    @Override
    public Vehicule create(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehicule not found"));
    }

    @Override
    public List<VehiculeDTO> findAll() {
        List<VehiculeDTO> vehiculeDTOS = new ArrayList<>();
        for (Vehicule vehicule : vehiculeRepository.findAll()){
            vehiculeDTOS.add(toDTO(vehicule));
        }
        return vehiculeDTOS;
    }

    @Override
    public VehiculeDTO toDTO(Vehicule vehicule) {
        VehiculeDTO vehiculeDTO= new VehiculeDTO();
        vehiculeDTO.setImmatriculation(vehicule.getImmatriculation());
        vehiculeDTO.setCategorie(vehicule.getCategorie());
        vehiculeDTO.setMarque(vehicule.getMarque());
        vehiculeDTO.setTarifJournalier(vehicule.getTarifJournalier());
        vehiculeDTO.setModel(vehicule.getModel());
        vehiculeDTO.setNomAgence(vehicule.getAgence().getNom());
        return null;
    }

    @Override
    public void deleteById(Long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = findById(idVehicule);
        Agence agence = agenceRepository.findById(idAgence).orElseThrow(()->new RuntimeException("Agence Not Found"));
        vehicule.setAgence(agence);

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findById(idVehicule);
        Equipement equipement = equipementRepository.findById(idEquipement).orElseThrow(()->new RuntimeException("Equipement Not Found"));
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void unassignEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findById(idVehicule);
        Equipement equipement = equipementRepository.findById(idEquipement).orElseThrow(()->new RuntimeException("Equipement Not Found"));
        vehicule.getEquipements().remove(equipement);
        vehiculeRepository.save(vehicule);

    }

    @Transactional
    @Override
    public Vehicule addAndAssignAgence(Vehicule vehicule, Long idAgence) {
        Agence agence = agenceRepository.findById(idAgence).orElseThrow(()->new RuntimeException("Agence Not Found"));
        vehicule.setAgence(agence);

        return vehiculeRepository.save(vehicule);
    }


}
