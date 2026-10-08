package tn.esprit.samarjandoubi4cce10.service.impls;

import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.repository.IVehiculeRepository;
import tn.esprit.samarjandoubi4cce10.service.IVehiculeService;

import java.util.List;

public class VehiculeServiceImpl implements IVehiculeService {

    private IVehiculeRepository vehiculeRepository;

    @Override
    public Vehicule create(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule findById(Long id) {
        return null;
    }

    @Override
    public List<Vehicule> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return null;
    }
}
