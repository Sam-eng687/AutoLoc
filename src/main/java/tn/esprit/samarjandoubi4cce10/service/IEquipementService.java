package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Equipement;


import java.util.List;

public interface IEquipementService {
    Equipement create (Equipement equipement);
    Equipement findById (Long id);
    List<Equipement> findAll();
    void deleteById (Long id);
    Equipement update(Equipement e);
}
