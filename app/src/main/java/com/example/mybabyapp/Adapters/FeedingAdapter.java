package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.FeedingModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class FeedingAdapter extends RecyclerView.Adapter<FeedingAdapter.ViewHolder>{

    ArrayList<FeedingModel> Tdata = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.feeding_output_file, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FeedingModel feedingModel = Tdata.get(position);

        holder.feeding_Time.setText(feedingModel.getFeeding_Time());
        holder.food_Type.setText(feedingModel.getFood_Type());
        holder.food_Quantity.setText(feedingModel.getFood_Quantity());
    }

    @Override
    public int getItemCount() {
        return Tdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView feeding_Time, food_Type, food_Quantity;
        private FeedingAdapter feedingAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            feeding_Time = itemView.findViewById(R.id.feeding_Time);
            food_Type = itemView.findViewById(R.id.food_Type);
            food_Quantity = itemView.findViewById(R.id.food_Quantity);
        }
    }

    public FeedingAdapter(ArrayList<FeedingModel> Tdata){
        this.Tdata = Tdata;
    }
}


