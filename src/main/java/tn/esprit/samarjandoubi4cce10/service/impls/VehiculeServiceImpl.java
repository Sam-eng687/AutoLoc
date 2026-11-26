package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.samarjandoubi4cce10.domain.Agence;
import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;
import tn.esprit.samarjandoubi4cce10.domain.Equipement;
import tn.esprit.samarjandoubi4cce10.domain.StatutVehicule;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.repository.IAgenceRepository;
import tn.esprit.samarjandoubi4cce10.repository.IEquipementRepository;
import tn.esprit.samarjandoubi4cce10.repository.IVehiculeRepository;
import tn.esprit.samarjandoubi4cce10.service.IVehiculeService;
import tn.esprit.samarjandoubi4cce10.web.dto.NbVehiculesAgenceDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeRequestDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResponseDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResumeDTO;
import tn.esprit.samarjandoubi4cce10.web.mapper.VehiculeMapper;
import tn.esprit.samarjandoubi4cce10.web.exception.ResourceNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final IEquipementRepository equipementRepository;
    private final VehiculeMapper vehiculeMapper;


    @Override
    @Transactional
    public VehiculeResponseDTO create(VehiculeRequestDTO dto) {
        if (vehiculeRepository.existsByImmatriculation(dto.immatriculation())) {
            throw new IllegalStateException("Immatriculation déjà utilisée : " + dto.immatriculation());
        }
        Vehicule vehicule = vehiculeMapper.toEntity(dto);
        Agence agence = agenceRepository.findById(dto.agenceId())
                .orElseThrow(() -> new ResourceNotFoundException("Agence introuvable : " + dto.agenceId()));
        vehicule.setAgence(agence);
        return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
    }

    @Override
    @Transactional(readOnly = true)
    public VehiculeResponseDTO findById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule introuvable : " + id));
        return vehiculeMapper.toDto(vehicule);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findAll() {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findAll());
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
    @Transactional
    public VehiculeResponseDTO assignAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule introuvable : " + idVehicule));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
    }

    @Override
    @Transactional
    public VehiculeResponseDTO assignEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new ResourceNotFoundException("Équipement introuvable : " + idEquipement));
        vehicule.getEquipements().add(equipement);
        return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
    }

    @Override
    @Transactional
    public void unassignEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new ResourceNotFoundException("Équipement introuvable : " + idEquipement));
        vehicule.getEquipements().remove(equipement);
        vehiculeRepository.save(vehicule);
    }


    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByMarque(String marque) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByMarque(marque));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByCategorieAndStatut(CategorieVehicule categorie, StatutVehicule statut) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByCategorieAndStatut(categorie, statut));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByTarif(BigDecimal min, BigDecimal max) {
        return vehiculeMapper.toResumeDtoList(
                vehiculeRepository.findByTarifJournalierBetweenOrderByTarifJournalierAsc(min, max));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByModel(String motCle) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByModelContainingIgnoreCase(motCle));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByCategories(List<CategorieVehicule> categories) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByCategorieIn(categories));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByImmatriculation(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }

    @Override
    @Transactional(readOnly = true)
    public long countByStatut(StatutVehicule statut) {
        return vehiculeRepository.countByStatut(statut);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findTroisMoinsChers() {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findTop3ByOrderByTarifJournalierAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByAgence(Long agenceId) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByAgenceIdAgence(agenceId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findSansAgence() {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByAgenceIsNull());
    }


    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByVilleAgence(String ville) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByVilleAgence(ville));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findByEquipement(String libelle) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findByEquipement(libelle));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findAvecAuMoinsNEquipements(long n) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findAvecAuMoinsNEquipements(n));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findReservesParClient(Long clientId) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findReservesParClient(clientId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findJamaisReserves() {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findJamaisReserves());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResumeDTO> findEnMaintenanceLe(LocalDate date) {
        return vehiculeMapper.toResumeDtoList(vehiculeRepository.findEnMaintenanceLe(date));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NbVehiculesAgenceDTO> compterParAgence() {
        return vehiculeRepository.compterParAgence();
    }
}