package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Reservation;
import tn.esprit.samarjandoubi4cce10.repository.IReservationRepository;
import tn.esprit.samarjandoubi4cce10.service.IReservationService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    @Override
    public Reservation create(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(()-> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
