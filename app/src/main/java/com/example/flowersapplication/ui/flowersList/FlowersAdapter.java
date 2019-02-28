package com.example.flowersapplication.ui.flowersList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.flowersapplication.R;
import com.example.flowersapplication.local.entities.FlowerEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowersViewHolder>{

    private static final String TAG = "FlowersAdapter";

    private List<FlowerEntity> mList;
    private Context context;

    public FlowersAdapter(List<FlowerEntity> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public FlowersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item,viewGroup,false);
        return new FlowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowersViewHolder flowersViewHolder, int i) {
        FlowerEntity flower = mList.get(i);

        flowersViewHolder.flowerName.setText(flower.getName());
        flowersViewHolder.flowerCategory.setText(flower.getCategory());
        flowersViewHolder.flowerPrice.setText(String.valueOf(flower.getPrice()));

        if (flower.getPhoto()!=null){
            Glide.with(context)
                    .load(flower.getPhoto())
                    .into(flowersViewHolder.flowerImage);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void SetItems (List<FlowerEntity> mList){
        if (mList!=null&& !mList.isEmpty()){
            this.mList = mList;
            notifyDataSetChanged();
        }
    }


    public class FlowersViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.flower_name)
        TextView flowerName;
        @BindView(R.id.flower_category)
        TextView flowerCategory;
        @BindView(R.id.flower_price)
        TextView flowerPrice;
        @BindView(R.id.flower_image)
        ImageView flowerImage;



        public FlowersViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
