package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.model.Airplane;

import java.util.Optional;

public interface AirplaneService {
    boolean approve(AirplaneDto dto);
    Airplane save (Airplane plane);
    Optional<Airplane> load (Long id);
    Airplane fromDto (AirplaneDto dto);
    AirplaneDto toDto (Airplane plane);
    Long getID (Airplane plane);
}
