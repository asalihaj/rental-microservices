package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.ClientDto;
import com.rental.bookingservice.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);
}
