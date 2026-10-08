package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.repository.IVehiculeRepository;
import tn.esprit.samarjandoubi4cce10.service.IVehiculeService;

import java.util.List;
@Service
@RequiredArgsConstructor


public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;


    @Override
    public Vehicule create(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehicule not found"));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}
