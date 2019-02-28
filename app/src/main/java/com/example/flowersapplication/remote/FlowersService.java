package com.example.flowersapplication.remote;

import com.example.flowersapplication.remote.model.Flowers;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface FlowersService {

    @GET("feeds/flowers.json")
    Flowable<List<Flowers>> getFlowersFromApi();


}
