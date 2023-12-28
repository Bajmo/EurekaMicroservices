package me.bajmo.services.client.controllers;

import me.bajmo.services.client.entities.Client;
import me.bajmo.services.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return this.clientService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client) {
        clientService.addClient(client);
    }
}
