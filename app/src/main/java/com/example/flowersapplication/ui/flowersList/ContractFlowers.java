package com.example.flowersapplication.ui.flowersList;

import android.content.Context;

import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.ui.base.IBaseView;

import java.util.List;

public interface ContractFlowers {

    interface ContractPresenter {

        void getFlowers (Context context);

        void getFlowersFromApi ();

        void getFlowersFromDb();

        void saveFlowers(List<FlowerEntity> items);



    }

    interface ContractView extends IBaseView{
        void onFlowersReady (List <FlowerEntity> items);

    }
}
