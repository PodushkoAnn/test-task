package com.mcb.creditfactory.service.value;

import com.mcb.creditfactory.dto.ValueDto;
import com.mcb.creditfactory.model.Value;

public interface ValueService {
    Value save(Value value);
    Value fromDto(ValueDto dto);
    ValueDto toDto(Value value);
    boolean approve(ValueDto dto);
    void delete(Value value);

}
