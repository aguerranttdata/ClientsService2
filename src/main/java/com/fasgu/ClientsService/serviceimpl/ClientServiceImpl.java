package com.fasgu.ClientsService.serviceimpl;

import com.fasgu.ClientsService.dto.ClientRequest;
import com.fasgu.ClientsService.dto.ClientResponse;
import com.fasgu.ClientsService.exception.client.ClientCreationException;
import com.fasgu.ClientsService.model.Client;
import com.fasgu.ClientsService.repository.ClientRepository;
import com.fasgu.ClientsService.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Flux<ClientResponse> getAll() {
        return clientRepository.findAll().map(ClientResponse::fromModel);
    }

    @Override
    public Mono<ClientResponse> save(ClientRequest clientRequest) {
        return Mono.just(clientRequest)
                .map(ClientRequest::toModel)
                .flatMap(client -> clientRepository.save(client))
                .map(ClientResponse::fromModel)
                .onErrorMap(ex -> new ClientCreationException(ex.getMessage()))
                .doOnError(ex -> log.error("Error save client" +ex));
    }
}
