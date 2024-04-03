package com.artemnizhnyk.datageneratorgrpcmicroservice.web.mapper;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
