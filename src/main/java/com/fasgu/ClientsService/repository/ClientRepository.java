package com.fasgu.ClientsService.repository;

import com.fasgu.ClientsService.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
