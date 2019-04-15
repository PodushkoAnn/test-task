package com.mcb.creditfactory.service.value;

import com.mcb.creditfactory.dto.ValueDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Value;
import com.mcb.creditfactory.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueServiceImpl implements ValueService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private ValueRepository valueRepository;

    @Override
    public Value save(Value value) {
        return valueRepository.save(value);
    }

    @Override
    public Value fromDto(ValueDto dto) {
        return new Value(
                dto.getId(),
                dto.getObjectType(),
                dto.getExternalId(),
                dto.getValue(),
                dto.getDate()
        );
    }

    @Override
    public ValueDto toDto(Value value) {
        return new ValueDto(
                value.getId(),
                value.getObjectType(),
                value.getExternalId(),
                value.getValue(),
                value.getDate()
        );
    }

    @Override
    public boolean approve(ValueDto dto) {
        return approveService.approveValue(dto) == 0;
    }

}
