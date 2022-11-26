package com.java.bit.service;

import com.java.bit.dto.SectorDto;

import java.util.List;
import java.util.Optional;

public interface SectorService {

    public void saveSector(SectorDto sectorDto);

    public Optional<SectorDto> updateSector(Long sectorId, SectorDto sectorDto);

    public List<SectorDto> getSectors();

    public Optional<SectorDto> getSectorById(Long sectorId);

    public void deleteSectorById(Long sectorId);


}
