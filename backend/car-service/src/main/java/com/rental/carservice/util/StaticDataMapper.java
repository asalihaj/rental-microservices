package com.rental.carservice.util;

import com.rental.carservice.mapper.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class StaticDataMapper {
    private final CategoryMapper categoryMapper;
    private final ColorMapper colorMapper;
    private final StatusMapper statusMapper;
    private final ModelMapper modelMapper;
    private final FuelTypeMapper fuelTypeMapper;
    private final UtilityMapper utilityMapper;
    private final BrandMapper brandMapper;
}
