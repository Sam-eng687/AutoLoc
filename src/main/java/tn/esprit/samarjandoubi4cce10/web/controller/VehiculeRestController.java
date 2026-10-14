package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.service.impls.VehiculeServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Vehicules")
public class VehiculeRestController {
    private final VehiculeServiceImpl vehiculeService;

    @PostMapping
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @GetMapping("{id}")
    public Vehicule getVehicule(@PathVariable Long id) {
        return vehiculeService.findById(id);

    }
    @GetMapping
    public List<Vehicule> getVehicule(){
        return vehiculeService.findAll();
    }
    @PutMapping
    public Vehicule update (@RequestBody Vehicule vehicule){
        return vehiculeService.update(vehicule);
    }
}