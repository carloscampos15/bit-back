package com.java.bit.controller;

import com.java.bit.dto.SectorDto;
import com.java.bit.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("")
    public ResponseEntity<List<SectorDto>> getSectors() {
        return ResponseEntity.status(HttpStatus.OK).body(
                sectorService.getSectors()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> getSector(@PathVariable("id") Long sectorId) {
        Optional<SectorDto> sector = sectorService.getSectorById(sectorId);

        return sector
                .map(sectorDto -> ResponseEntity.status(HttpStatus.OK).body(sectorDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Boolean> saveSector(@RequestBody SectorDto sectorDto) {
        sectorService.saveSector(sectorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDto> updateSector(@PathVariable("id") Long sectorId, @RequestBody SectorDto sectorDto) {
        Optional<SectorDto> sector = sectorService.updateSector(sectorId, sectorDto);

        return sector
                .map(updated -> ResponseEntity.status(HttpStatus.OK).body(updated))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSector(@PathVariable("id") Long sectorId) {
        sectorService.deleteSectorById(sectorId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
