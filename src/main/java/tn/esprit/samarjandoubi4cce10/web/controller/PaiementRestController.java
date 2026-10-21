package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Paiement;
import tn.esprit.samarjandoubi4cce10.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("Paiement")
@RequiredArgsConstructor
public class PaiementRestController {
    private final IPaiementService paiementService;
    public Paiement add(@RequestBody Paiement paiement){

        return paiementService.create(paiement);
    }
    @GetMapping("{id}")
    public Paiement getPaiement(@PathVariable Long id) {
        return paiementService.findById(id);
    }
    @GetMapping
    public List<Paiement> getPaiement(){
        return paiementService.findAll();
    }
    @PutMapping
    public Paiement update (@RequestBody Paiement p){
        return paiementService.update(p);
    }
}
