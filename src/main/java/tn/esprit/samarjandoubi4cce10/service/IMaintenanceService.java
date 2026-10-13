package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance create (Maintenance maintenance);
    Maintenance findById (Long id);
    List<Maintenance> findAll();
    void deleteById (Long id);
    Maintenance update(Maintenance m);
}
