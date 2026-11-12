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
    public List<Vehicule> getVehicule() {
        return vehiculeService.findAll();
    }

    @PutMapping
    public Vehicule update(@RequestBody Vehicule v) {
        return vehiculeService.update(v);
    }

    @PutMapping("{idVehicule}/agences/{idAgence}")

    public Vehicule assignAgence(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return vehiculeService.assignAgence(idVehicule, idAgence);
    }
    @PutMapping("{idVehiculel}/equipements/{idEquipement}")
    public Vehicule assignEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return vehiculeService.assignEquipement(idVehicule, idEquipement);
    }

   @DeleteMapping("{idVehiculel}/equipements/{idEquipement}")
    public void unassignEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        vehiculeService.unassignEquipement(idVehicule, idEquipement);
   }
   @PutMapping("/agencces/{idAgence}")
    public Vehicule addAndAssignAgence(Vehicule vehicule, Long idAgence){
        return vehiculeService.addAndAssignAgence(vehicule, idAgence);

   }
}
