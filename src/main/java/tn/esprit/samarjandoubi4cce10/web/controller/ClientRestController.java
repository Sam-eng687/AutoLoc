package tn.esprit.samarjandoubi4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.samarjandoubi4cce10.domain.Client;
import tn.esprit.samarjandoubi4cce10.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("Client")
@RequiredArgsConstructor
public class ClientRestController {
    private final IClientService clientService;
    @PostMapping
    public Client add(@RequestBody Client client){
        return clientService.create(client);
    }
    @GetMapping("{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.findById(id);
    }
    @GetMapping
    public List<Client> getClient(){
        return clientService.findAll();
    }
    @PutMapping
    public Client update (@RequestBody Client cl){
        return clientService.update(cl);
    }
}
