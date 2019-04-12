package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Value;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ValueRepository extends CrudRepository <Value, Long> {

    List<Value> findValuesByExternalIdAndObjectType(Long id, CollateralType type);

    Value findLastValueByExternalIdAndObjectType(Long id, CollateralType type);

}
