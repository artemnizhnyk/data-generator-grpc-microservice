package com.artemnizhnyk.datageneratorgrpcmicroservice.service;

import com.artemnizhnyk.datageneratorgrpcmicroservice.model.Data;
import com.artemnizhnyk.grpccommon.DataServerGrpc;
import com.artemnizhnyk.grpccommon.GRPCData;
import com.artemnizhnyk.grpccommon.MeasurementType;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GRPCDataServiceImpl implements GRPCDataService {

    @GrpcClient(value = "data-generator-blocking")
    private DataServerGrpc.DataServerBlockingStub blockingStub;

    @GrpcClient(value = "data-generator-async")
    private DataServerGrpc.DataServerStub asyncStub;

    @Override
    public void send(final Data data) {
        GRPCData req = getGrpcDataRequest(data);
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(final Empty empty) {
            }

            @Override
            public void onError(final Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };
        asyncStub.addData(req, responseObserver);
    }

    @Override
    public void send(final List<Data> data) {
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(final Empty empty) {
            }

            @Override
            public void onError(final Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };
        StreamObserver<GRPCData> requestObserver = asyncStub.addStreamOfData(responseObserver);
        for (Data d : data) {
            GRPCData req = getGrpcDataRequest(d);
            requestObserver.onNext(req);
        }
        requestObserver.onCompleted();
    }

    private static GRPCData getGrpcDataRequest(final Data data) {
        GRPCData req = GRPCData.newBuilder()
                .setSensorId(data.getSensorId())
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setSeconds(
                                        data.getTimestamp().toEpochSecond(ZoneOffset.UTC)
                                )
                                .build()
                )
                .setMeasurementType(
                        MeasurementType.valueOf(data.getMeasurementType().name())
                )
                .setMeasurement(data.getMeasurement())
                .build();
        return req;
    }
}
