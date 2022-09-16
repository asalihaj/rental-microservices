package com.rental.bookingservice.service.contract;

import com.rental.bookingservice.dto.contract.ContractCreationDto;
import com.rental.bookingservice.dto.contract.ContractDto;

import java.util.List;
import java.util.UUID;

public class ContractServiceImpl implements ContractService {
    @Override
    public List<ContractDto> getAll(UUID companyId) {
        return null;
    }

    @Override
    public ContractDto get(UUID id) {
        return null;
    }

    @Override
    public ContractDto create(ContractCreationDto contractDto) {
        return null;
    }

    @Override
    public ContractDto edit(ContractCreationDto contractDto) {
        return null;
    }

    @Override
    public int delete(UUID id) {
        return 0;
    }
}
