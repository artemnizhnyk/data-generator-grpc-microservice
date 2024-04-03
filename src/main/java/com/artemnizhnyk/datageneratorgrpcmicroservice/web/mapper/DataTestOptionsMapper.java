package com.artemnizhnyk.datageneratorgrpcmicroservice.web.mapper;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.test.DataTestOptions;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
