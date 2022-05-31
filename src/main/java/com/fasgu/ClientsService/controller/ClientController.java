package com.fasgu.ClientsService.controller;

import com.fasgu.ClientsService.dto.ClientRequest;
import com.fasgu.ClientsService.dto.ClientResponse;
import com.fasgu.ClientsService.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor

public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public Flux<ClientResponse> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClientResponse> save(@Valid @RequestBody ClientRequest clientRequest) {
        return clientService.save(clientRequest);
    }


}
