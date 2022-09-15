package com.rental.carservice.controller;

import com.rental.carservice.dto.group.GroupCreationDto;
import com.rental.carservice.dto.group.GroupDto;
import com.rental.carservice.service.group.GroupService;
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

    @GetMapping("/{companyId}")
    public ResponseEntity<List<GroupDto>> getAll(@PathVariable UUID companyId) {
        return new ResponseEntity<>(groupService.getAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody GroupCreationDto groupDto) {
        groupService.create(groupDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupDto> edit(@PathVariable UUID id, @RequestBody GroupDto groupDto) {
        return new ResponseEntity<>(groupService.edit(id, groupDto), HttpStatus.OK);
    }

    @PutMapping("/{groupId}/add-car/{carId}")
    public ResponseEntity<HttpStatus> editCarGroup(@PathVariable UUID carId, @PathVariable UUID groupId) {
        groupService.editCarGroup(carId, groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id) {
        int code = groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}
