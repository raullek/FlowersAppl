package com.example.flowersapplication.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.flowersapplication.local.dao.FlowersDao;
import com.example.flowersapplication.local.entities.FlowerEntity;

@Database(entities = FlowerEntity.class,version = 1,exportSchema = false)
public abstract class LocalDataSource extends RoomDatabase {

    public abstract FlowersDao getFlowerDao();
}
