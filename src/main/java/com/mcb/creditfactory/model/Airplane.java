package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @ManyToOne
    @JoinFormula("(SELECT v.id FROM value v WHERE v.external_id = id and v.object_type = 'AIRPLANE' ORDER BY v.assessment_date DESC LIMIT 1)")
//    @JoinColumnsOrFormulas({
//            @JoinColumnOrFormula(formula = @JoinFormula(value = "(SELECT v.id FROM value v WHERE v.external_id = id ORDER BY v.assessment_date DESC LIMIT 1)")),
//            @JoinColumnOrFormula(formula = @JoinFormula(value = "SELECT v.id FROM value v WHERE v.object_type = 'AIRPLANE'"))
//    })
    private Value value;
}
