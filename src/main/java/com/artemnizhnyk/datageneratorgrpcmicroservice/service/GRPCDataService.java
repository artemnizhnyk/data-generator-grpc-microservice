package com.artemnizhnyk.datageneratorgrpcmicroservice.service;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;

import java.util.List;

public interface GRPCDataService {

    void send(final Data data);

    void send(final List<Data> data);


}
