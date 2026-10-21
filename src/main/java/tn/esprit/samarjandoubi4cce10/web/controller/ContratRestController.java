package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Contrat;
import tn.esprit.samarjandoubi4cce10.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("Contrat")
@RequiredArgsConstructor
public class ContratRestController {
    private final IContratService contratService;
    public Contrat add(@RequestBody Contrat contrat){
        return contratService.create(contrat);
    }
    @GetMapping("{id}")
    public Contrat getContrat(@PathVariable Long id) {
        return contratService.findById(id);
    }
    @GetMapping
    public List<Contrat> getContrat(){
        return contratService.findAll();
    }
    @PutMapping
    public Contrat update (@RequestBody Contrat c){
        return contratService.update(c);
    }
}
