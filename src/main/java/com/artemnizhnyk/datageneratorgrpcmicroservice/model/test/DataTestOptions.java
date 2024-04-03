package com.artemnizhnyk.datageneratorgrpcmicroservice.model.test;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataTestOptions {

    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}
