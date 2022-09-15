package com.rental.carservice.controller;

import com.rental.carservice.dto.season.SeasonCreationDto;
import com.rental.carservice.dto.season.SeasonDto;
import com.rental.carservice.service.season.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/seasons")
@RequiredArgsConstructor
public class SeasonController {
    private final SeasonService seasonService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<SeasonDto>> getAllCompanySeasons(@PathVariable UUID companyId) {
        return new ResponseEntity<>(seasonService.getAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SeasonDto> createSeason(@RequestBody SeasonCreationDto seasonDto) {
        return new ResponseEntity<>(seasonService.create(seasonDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeasonDto> editSeason(@PathVariable UUID id, @RequestBody SeasonCreationDto seasonDto) {
        return new ResponseEntity<>(seasonService.edit(id, seasonDto), HttpStatus.OK);
    }

    @PostMapping("/{seasonId}/add-to-group/{groupId}")
    public ResponseEntity<HttpStatus> addToGroup(@PathVariable UUID seasonId, @PathVariable UUID groupId) {
        int code = seasonService.addToGroup(seasonId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{seasonId}/remove-from-group/{groupId}")
    public ResponseEntity<HttpStatus> removeFromGroup(@PathVariable UUID seasonId, @PathVariable UUID groupId) {
        int code = seasonService.removeFromGroup(seasonId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSeason(@PathVariable UUID id) {
        int code = seasonService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}
