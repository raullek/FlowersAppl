package com.example.flowersapplication.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.flowersapplication.local.entities.FlowerEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface FlowersDao {

    @Query("SELECT * FROM flowers")
    Flowable<List<FlowerEntity>> getFlowersFromDb();

    @Insert
    void saveArticles(List<FlowerEntity> flowers);

    @Query("DELETE  FROM  flowers")
    void deleteFlowers();


}
