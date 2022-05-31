package com.fasgu.ClientsService.service;

import com.fasgu.ClientsService.dto.ClientRequest;
import com.fasgu.ClientsService.dto.ClientResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<ClientResponse> getAll();

    Mono<ClientResponse> save(ClientRequest clientRequest);
}
