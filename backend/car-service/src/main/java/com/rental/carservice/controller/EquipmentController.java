package com.rental.carservice.controller;

import com.rental.carservice.dto.equipment.EquipmentCreationDto;
import com.rental.carservice.dto.equipment.EquipmentDto;
import com.rental.carservice.service.equipment.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipments")
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<EquipmentDto>> getAll(@PathVariable UUID companyId) {
        return new ResponseEntity<>(equipmentService.getAllByCompany(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentDto> create(@RequestBody EquipmentCreationDto equipmentDto) {
        return new ResponseEntity<>(equipmentService.create(equipmentDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentDto> edit(@PathVariable UUID id, @RequestBody EquipmentDto equipmentDto) {
        return new ResponseEntity<>(equipmentService.edit(id, equipmentDto), HttpStatus.OK);
    }

    @PostMapping("/{equipmentId}/add-to-group/{groupId}")
    public ResponseEntity<HttpStatus> addToGroup(@PathVariable UUID equipmentId, @PathVariable UUID groupId) {
        int code = equipmentService.addToGroup(equipmentId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{equipmentId}/remove-from-group/{groupId}")
    public ResponseEntity<HttpStatus> removeFromGroup(@PathVariable UUID equipmentId, @PathVariable UUID groupId) {
        int code = equipmentService.removeFromGroup(equipmentId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id) {
        int code = equipmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

}
