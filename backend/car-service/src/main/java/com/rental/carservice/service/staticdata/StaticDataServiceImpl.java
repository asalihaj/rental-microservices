package com.rental.carservice.service.staticdata;

import com.rental.carservice.dto.*;
import com.rental.carservice.repository.*;
import com.rental.carservice.util.StaticDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaticDataServiceImpl implements StaticDataService {
    private final ColorRepository colorRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final StatusRepository statusRepository;
    private final UtilityRepository utilityRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final StaticDataMapper dataMapper;

    @Override
    public List<ColorDto> getColors() {
        return colorRepository.findAll().stream()
                .map(color -> dataMapper.getColorMapper().toDto(color))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> dataMapper.getCategoryMapper().toDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandDto> getBrands() {
        return brandRepository.findAll().stream()
                .map(brand -> dataMapper.getModelMapper().toDto(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> getModels(UUID brandId) {
        return modelRepository.findAll().stream()
                .map(model -> dataMapper.getModelMapper().toDto(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<StatusDto> getStatuses() {
        return statusRepository.findAll().stream()
                .map(status -> dataMapper.getStatusMapper().toDto(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<FuelTypeDto> getFuelTypes() {
        return fuelTypeRepository.findAll().stream()
                .map(fuelType -> dataMapper.getFuelTypeMapper().toDto(fuelType))
                .collect(Collectors.toList());
    }

    @Override
    public List<UtilityDto> getUtilities() {
        return utilityRepository.findAll().stream()
                .map(utility -> dataMapper.getUtilityMapper().toDto(utility))
                .collect(Collectors.toList());
    }
}
