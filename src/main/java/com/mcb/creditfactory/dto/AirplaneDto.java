package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral{

    private Long id;
    private String model;
    private String brand;
    private String manufacturer;
    private Short year;
    private Integer fuelCapacity;
    private Integer seats;
    private BigDecimal value;

}
