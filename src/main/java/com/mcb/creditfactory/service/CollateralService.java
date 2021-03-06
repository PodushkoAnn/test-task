package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.dto.ValueDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Value;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import com.mcb.creditfactory.service.value.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.mcb.creditfactory.external.CollateralType.AIRPLANE;
import static com.mcb.creditfactory.external.CollateralType.CAR;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private ValueService valueService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {

        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            Value value = car.getValue();
            value.setObjectType(CAR);
            valueService.save(value);

            boolean approved = carService.approve(car);
            if (!approved) {
                valueService.delete(value);
                return null;
            }

            Long id = Optional.of(car)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);

            value.setExternalId(id);
            valueService.save(value);

            return id;

        } else if(object instanceof AirplaneDto){
            AirplaneDto plane = (AirplaneDto) object;
            Value value = plane.getValue();
            value.setObjectType(AIRPLANE);
            valueService.save(value);
            boolean approved = airplaneService.approve(plane);
            if (!approved) {
                valueService.delete(value);
                return null;
            }

            Long id = Optional.of(plane)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::save)
                    .map(airplaneService::getID)
                    .orElse(null);
            value.setExternalId(id);
            valueService.save(value);
            return id;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Collateral getInfo(Collateral object) {

        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        } else if (object instanceof AirplaneDto) {
            return Optional.of((AirplaneDto) object)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::getID)
                    .flatMap(airplaneService::load)
                    .map(airplaneService::toDto)
                    .orElse(null);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Value addValue(ValueDto dto){
        boolean approved = valueService.approve(dto);
        if(!approved) return null;

        Value v = valueService.fromDto(dto);
        if(!checkIfExists(v.getExternalId(), v.getObjectType())) return null;

        return valueService.save(v);
    }

    private boolean checkIfExists(Long id, CollateralType type){
        switch(type){
            case CAR: return carService.load(id).isPresent();
            case AIRPLANE: return airplaneService.load(id).isPresent();
        }
        return false;
    }

}
