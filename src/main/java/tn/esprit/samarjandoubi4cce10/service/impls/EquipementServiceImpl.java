package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Equipement;
import tn.esprit.samarjandoubi4cce10.repository.IEquipementRepository;
import tn.esprit.samarjandoubi4cce10.service.IEquipementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id).orElseThrow(()-> new RuntimeException("Equipement not found"));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        equipementRepository.deleteById(id);

    }

    @Override
    public Equipement update(Equipement e) {
        return equipementRepository.save(e);
    }
}
