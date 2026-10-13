package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Paiement;
import tn.esprit.samarjandoubi4cce10.repository.IPaiementRepository;
import tn.esprit.samarjandoubi4cce10.service.IPaiementService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    private final IPaiementRepository paiementRepository;
    @Override
    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id).orElseThrow(()-> new RuntimeException("Payment not found"));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paiementRepository.deleteById(id);

    }

    @Override
    public Paiement update(Paiement p) {
        return paiementRepository.save(p);
    }
}
