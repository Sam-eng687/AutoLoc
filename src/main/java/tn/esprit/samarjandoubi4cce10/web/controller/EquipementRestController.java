package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Equipement;
import tn.esprit.samarjandoubi4cce10.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("Equipement")
@RequiredArgsConstructor
public class EquipementRestController {
    private final IEquipementService equipementService;
    public Equipement add(@RequestBody Equipement equipement){
        return equipementService.create(equipement);
    }
    @GetMapping("{id}")
    public Equipement getEquipement(@PathVariable Long id) {
        return equipementService.findById(id);
    }
    @GetMapping
    public List<Equipement> getEquipement(){
        return equipementService.findAll();
    }
    @PutMapping
    public Equipement update (@RequestBody Equipement e){
        return equipementService.update(e);
    }
}
