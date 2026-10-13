package tn.esprit.samarjandoubi4cce10.service;

import tn.esprit.samarjandoubi4cce10.domain.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create (Reservation res);
    Reservation findById (Long id);
    List<Reservation> findAll();
    void deleteById (Long id);
    Reservation update(Reservation reservation);
}
