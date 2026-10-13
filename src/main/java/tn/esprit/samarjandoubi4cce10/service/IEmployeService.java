package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Employe;


import java.util.List;

public interface IEmployeService {
    Employe create (Employe employe);
    Employe findById (Long id);
    List<Employe> findAll();
    void deleteById (Long id);
    Employe update(Employe e);
}
