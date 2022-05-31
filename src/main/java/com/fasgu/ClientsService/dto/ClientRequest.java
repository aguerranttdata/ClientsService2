package com.fasgu.ClientsService.dto;

import com.fasgu.ClientsService.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ClientRequest {
    @NotBlank(message = "firstName cannot be empty")
    private String firstName;
    @NotBlank(message = "lastName cannot be empty")
    private String lastName;
    @NotBlank(message = "documentType cannot be empty")
    @Pattern(regexp = "^(DNI|CE|Pasaporte)$", message = "The documentType must have a value from: 'DNI' or 'CE' or 'Pasaporte'")
    private String documentType;
    @NotBlank(message = "documentNumber cannot be empty")
    private String documentNumber;

    public Client toModel() {
        return Client.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .documentType(this.documentType)
                .documentNumber(this.documentNumber)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
