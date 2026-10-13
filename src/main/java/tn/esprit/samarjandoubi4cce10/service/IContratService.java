package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Contrat;


import java.util.List;

public interface IContratService {
    Contrat create (Contrat contrat);
    Contrat findById (Long id);
    List<Contrat> findAll();
    void deleteById (Long id);
    Contrat update(Contrat c);
}
