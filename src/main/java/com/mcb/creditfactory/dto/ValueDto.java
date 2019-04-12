package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("value")
public class ValueDto {

    private Long id;
    private CollateralType objectType;
    private Long externalId;
    private BigDecimal value;
    private LocalDate date;
}
