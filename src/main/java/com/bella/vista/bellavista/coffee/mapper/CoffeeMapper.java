package com.bella.vista.bellavista.coffee.mapper;

import com.bella.vista.bellavista.coffee.dto.CoffeeDto;
import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper extends BaseMapper<Coffee, CoffeeDto> { }
