package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Reservation;
import tn.esprit.samarjandoubi4cce10.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("Reservation")
@RequiredArgsConstructor

public class ReservationRestController {
    private final IReservationService reservationService;
    public Reservation add(@RequestBody Reservation reservation){
        return reservationService.create(reservation);
    }
    @GetMapping("{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.findById(id);
    }
    @GetMapping
    public List<Reservation> getReservation(){
        return reservationService.findAll();
    }
    @PutMapping
    public Reservation update (@RequestBody Reservation r){
        return reservationService.update(r);
    }




}
