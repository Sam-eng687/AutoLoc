package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Employe;
import tn.esprit.samarjandoubi4cce10.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("Employe")
@RequiredArgsConstructor
public class EmployeRestController {
    private final IEmployeService employeService;
    @PostMapping
    public Employe add(@RequestBody Employe e){
        return employeService.create(e);
    }
    @GetMapping("{id}")
    public Employe getEmploye(@PathVariable Long id) {
        return employeService.findById(id);
    }
    @GetMapping
    public List<Employe> getEmploye(){
        return employeService.findAll();
    }
    @PutMapping
    public Employe update (@RequestBody Employe e){
        return employeService.update(e);
    }
}
