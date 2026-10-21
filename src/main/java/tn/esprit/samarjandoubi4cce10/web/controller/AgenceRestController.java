package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Agence;
import tn.esprit.samarjandoubi4cce10.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("Agence")
@RequiredArgsConstructor
public class AgenceRestController {
    private final IAgenceService agenceService;

    @PostMapping
    public Agence add(@RequestBody Agence agence){
        return agenceService.create(agence);
    }
    @GetMapping("{id}")
    public Agence getAgence(@PathVariable Long id) {
        return agenceService.findById(id);
    }
    @GetMapping
    public List<Agence> getAgence(){
        return agenceService.findAll();
    }
    @PutMapping
    public Agence update (@RequestBody Agence ag){
        return agenceService.update(ag);
    }
}
