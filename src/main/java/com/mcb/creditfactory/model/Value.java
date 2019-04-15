package com.mcb.creditfactory.model;

import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VALUE")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column (name = "object_type")
    @Enumerated(EnumType.STRING)
    private CollateralType objectType;

    @Column (name = "external_id")
    private Long externalId;

    @Column (name = "assessed_value")
    private BigDecimal value;

//    @CreationTimestamp
    @Column (name = "assessment_date")
    private LocalDate date;

    public Value(String value){
        this.value = new BigDecimal(value);
    }

}
