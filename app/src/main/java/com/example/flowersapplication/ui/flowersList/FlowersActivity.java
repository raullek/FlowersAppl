package com.example.flowersapplication.ui.flowersList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.flowersapplication.FlowersApp;
import com.example.flowersapplication.R;
import com.example.flowersapplication.di.component.DaggerFlowersComponent;
import com.example.flowersapplication.di.component.FlowersComponent;
import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowersActivity extends BaseActivity implements ContractFlowers.ContractView {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    FlowersPresenter flowersPresenter;

    private FlowersAdapter mFlowersAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        ButterKnife.bind(this);

        FlowersComponent flowersComponent = DaggerFlowersComponent.builder()
                .appComponent(FlowersApp.getAppComponent())
                .build();
        flowersComponent.inject(this);


        flowersPresenter.attachView(this);
        flowersPresenter.getFlowers(this);

        setUp();



    }

    @Override
    protected void setUp() {
        mFlowersAdapter = new FlowersAdapter(new ArrayList<>(),this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFlowersAdapter);





    }

    @Override
    public void onFlowersReady(List<FlowerEntity> items) {

        if (items!=null&& !items.isEmpty()){
            mFlowersAdapter.setItems(items);
        }

    }
}
