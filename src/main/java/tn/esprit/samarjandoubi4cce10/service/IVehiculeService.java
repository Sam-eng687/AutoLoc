package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule v);
    Vehicule findById (Long id);
    List<Vehicule> findAll();
    void deleteById (Long id);
    Vehicule update(Vehicule vehicule);
}
