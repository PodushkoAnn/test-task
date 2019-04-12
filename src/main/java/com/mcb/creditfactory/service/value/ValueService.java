package com.mcb.creditfactory.service.value;

import com.mcb.creditfactory.dto.ValueDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Value;

import java.util.List;

public interface ValueService {
    Value save(Value value);
    Value fromDto(ValueDto dto);
    ValueDto toDto(Value value);
    boolean approve(ValueDto dto);

    List<Value> loadObjectList(Long externalId, CollateralType type);

    Value findLastValue(Long externalId, CollateralType type);
}
