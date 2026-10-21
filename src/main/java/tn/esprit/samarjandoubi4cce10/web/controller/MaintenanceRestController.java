package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Maintenance;
import tn.esprit.samarjandoubi4cce10.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("Maintenance")
@RequiredArgsConstructor
public class MaintenanceRestController {
    private final IMaintenanceService maintenanceService;
    @PostMapping
    public Maintenance add(@RequestBody Maintenance maintenance){

        return maintenanceService.create(maintenance);
    }
    @GetMapping("{id}")
    public Maintenance getMaintenance(@PathVariable Long id) {
        return maintenanceService.findById(id);
    }
    @GetMapping
    public List<Maintenance> getMaintenance(){
        return maintenanceService.findAll();
    }
    @PutMapping
    public Maintenance update (@RequestBody Maintenance m){
        return maintenanceService.update(m);
    }
}
