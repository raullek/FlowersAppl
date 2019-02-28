package com.example.flowersapplication.ui.flowersList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flowersapplication.R;
import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.ui.base.BaseActivity;

import java.util.List;

public class FlowersActivity extends BaseActivity implements ContractFlowers.ContractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onFlowersReady(List<FlowerEntity> items) {

    }
}
