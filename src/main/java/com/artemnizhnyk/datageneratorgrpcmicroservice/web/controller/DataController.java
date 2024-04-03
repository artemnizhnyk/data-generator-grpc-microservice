package com.artemnizhnyk.datageneratorgrpcmicroservice.web.controller;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;
import com.artemnizhnyk.datageneratorgrpcmicroservice.model.test.DataTestOptions;
import com.artemnizhnyk.datageneratorgrpcmicroservice.service.GRPCDataService;
import com.artemnizhnyk.datageneratorgrpcmicroservice.service.TestDataService;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.dto.DataDto;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.dto.DataTestOptionsDto;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.mapper.DataMapper;
import com.artemnizhnyk.datageneratorgrpcmicroservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
@RestController
public class DataController {


    private final GRPCDataService grpcDataService;
    private final TestDataService testDataService;

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody final DataDto dataDto) {
        Data data = dataMapper.toEntity(dataDto);
        grpcDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody final DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
