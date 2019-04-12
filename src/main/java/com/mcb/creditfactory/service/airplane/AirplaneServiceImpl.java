package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane plane) {
        return airplaneRepository.save(plane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getModel(),
                dto.getBrand(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuelCapacity(),
                dto.getSeats(),
                dto.getValue()
        );
    }

    @Override
    public AirplaneDto toDto(Airplane plane) {
        return new AirplaneDto(
                plane.getId(),
                plane.getModel(),
                plane.getBrand(),
                plane.getManufacturer(),
                plane.getYear(),
                plane.getFuelCapacity(),
                plane.getSeats(),
                plane.getValue()
        );
    }

    @Override
    public Long getID(Airplane plane) {
        return plane.getId();
    }
}
