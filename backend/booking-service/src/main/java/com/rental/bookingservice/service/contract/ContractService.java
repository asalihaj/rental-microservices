package com.rental.bookingservice.service.contract;

import com.rental.bookingservice.dto.contract.ContractCreationDto;
import com.rental.bookingservice.dto.contract.ContractDto;

import java.util.List;
import java.util.UUID;

public interface ContractService {
    List<ContractDto> getAll(UUID companyId);
    ContractDto get(UUID id);
    ContractDto create(ContractCreationDto contractDto);
    ContractDto edit(ContractCreationDto contractDto);
    int delete(UUID id);
}
