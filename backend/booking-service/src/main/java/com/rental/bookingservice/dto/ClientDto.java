package com.rental.bookingservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String notes;
}
