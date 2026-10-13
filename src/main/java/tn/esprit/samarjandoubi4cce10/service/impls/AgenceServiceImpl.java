package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Agence;
import tn.esprit.samarjandoubi4cce10.repository.IAgenceRepository;
import tn.esprit.samarjandoubi4cce10.service.IAgenceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence findById(Long id) {
        return agenceRepository.findById(id).orElseThrow(()-> new RuntimeException("Agence not found"));
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        agenceRepository.deleteById(id);

    }

    @Override
    public Agence update(Agence a) {
        return agenceRepository.save(a);
    }
}
