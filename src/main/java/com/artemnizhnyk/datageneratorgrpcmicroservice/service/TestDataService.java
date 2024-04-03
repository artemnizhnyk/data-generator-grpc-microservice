package com.artemnizhnyk.datageneratorgrpcmicroservice.service;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.test.DataTestOptions;

public interface TestDataService {

    void sendMessages(final DataTestOptions testOptions);

}
