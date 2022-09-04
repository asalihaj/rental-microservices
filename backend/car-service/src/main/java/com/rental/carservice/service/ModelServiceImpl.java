package com.rental.carservice.service;

import com.rental.carservice.dto.ModelDto;
import com.rental.carservice.mapper.ModelMapper;
import com.rental.carservice.model.Model;
import com.rental.carservice.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ModelDto> getAll() {
        List<Model> models = modelRepository.findAll();
        List<ModelDto> modelDtos = new ArrayList<>();
        for (Model model : models) {
            modelDtos.add(modelMapper.toDto(model));
        }
        return modelDtos;
    }
}
