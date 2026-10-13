package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Agence;

import java.util.List;

public interface IAgenceService {
    Agence create (Agence agence);
    Agence findById (Long id);
    List<Agence> findAll();
    void deleteById (Long id);
    Agence update(Agence a);
}
