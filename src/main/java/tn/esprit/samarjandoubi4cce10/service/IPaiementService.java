package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Paiement;


import java.util.List;

public interface IPaiementService {
    Paiement create (Paiement paiement);
    Paiement findById (Long id);
    List<Paiement> findAll();
    void deleteById (Long id);
    Paiement update(Paiement p);
}
