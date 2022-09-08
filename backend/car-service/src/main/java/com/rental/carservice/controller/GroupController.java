package com.rental.carservice.controller;

import com.rental.carservice.dto.GroupDto;
import com.rental.carservice.model.Group;
import com.rental.carservice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAll() {
        return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/transfer/{carId}/to/{groupId}")
    public ResponseEntity<HttpStatus> editCarGroup(@PathVariable UUID carId, @PathVariable UUID groupId) {
        groupService.editCarGroup(carId, groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
