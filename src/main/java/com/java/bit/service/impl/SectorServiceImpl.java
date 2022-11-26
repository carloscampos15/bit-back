package com.java.bit.service.impl;

import com.java.bit.dto.SectorDto;
import com.java.bit.model.Sector;
import com.java.bit.repository.SectorRepository;
import com.java.bit.service.SectorService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveSector(SectorDto sectorDto) {
        Sector sector = modelMapper.map(sectorDto, Sector.class);
        sectorRepository.save(sector);
    }

    @Override
    public Optional<SectorDto> updateSector(Long sectorId, SectorDto sectorDto) {
        Optional<Sector> sector = sectorRepository.findById(sectorId);
        if (sector.isPresent()) {
            sector.get().setName(sectorDto.getName());
            Sector updated = sectorRepository.save(sector.get());
            return Optional.of(modelMapper.map(updated, SectorDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<SectorDto> getSectors() {
        List<SectorDto> sectors = new ArrayList<>();

        sectorRepository.findAll()
                .forEach(sector -> sectors.add(modelMapper.map(sector, SectorDto.class)));

        return sectors;
    }

    @Override
    public Optional<SectorDto> getSectorById(Long sectorId) {
        Optional<Sector> sector = sectorRepository.findById(sectorId);
        if (sector.isPresent()) {
            return Optional.of(modelMapper.map(sector, SectorDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSectorById(Long sectorId) {
        sectorRepository.deleteById(sectorId);
    }
}
