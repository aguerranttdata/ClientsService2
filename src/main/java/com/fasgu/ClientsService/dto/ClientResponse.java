package com.fasgu.ClientsService.dto;

import com.fasgu.ClientsService.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private LocalDateTime createdAt;

    public static ClientResponse fromModel(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .documentType(client.getDocumentType())
                .documentNumber(client.getDocumentNumber())
                .createdAt(client.getCreatedAt())
                .build();

    }
}
