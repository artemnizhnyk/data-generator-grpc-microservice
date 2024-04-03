package com.artemnizhnyk.datageneratorgrpcmicroservice.web.dto;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataTestOptionsDto {

    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}
