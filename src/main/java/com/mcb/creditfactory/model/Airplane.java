package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;
    private Integer seats;

    @Column(name = "assessed_value")
    private BigDecimal value;
}
