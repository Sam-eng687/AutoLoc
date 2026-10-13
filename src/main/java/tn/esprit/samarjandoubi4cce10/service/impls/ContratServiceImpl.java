package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Contrat;
import tn.esprit.samarjandoubi4cce10.repository.IContratRepository;
import tn.esprit.samarjandoubi4cce10.service.IContratService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id).orElseThrow(()-> new RuntimeException("Contrat not found"));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        contratRepository.deleteById(id);

    }

    @Override
    public Contrat update(Contrat c) {
        return contratRepository.save(c);
    }
}
