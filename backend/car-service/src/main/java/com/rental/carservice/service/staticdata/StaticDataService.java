package com.rental.carservice.service.staticdata;

import com.rental.carservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface StaticDataService {
    List<ColorDto> getColors();
    List<CategoryDto> getCategories();
    List<BrandDto> getBrands();
    List<ModelDto> getModels(UUID brandId);
    List<StatusDto> getStatuses();
    List<FuelTypeDto> getFuelTypes();
    List<UtilityDto> getUtilities();
}
