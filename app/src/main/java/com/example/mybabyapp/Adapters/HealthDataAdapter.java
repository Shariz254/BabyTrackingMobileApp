package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.DaiperModel;
import com.example.mybabyapp.Models.HealthDataModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class HealthDataAdapter extends RecyclerView.Adapter<HealthDataAdapter.ViewHolder> {

    ArrayList<HealthDataModel> healthData = new ArrayList<>();
    Context context;

    public HealthDataAdapter(ArrayList<HealthDataModel> healthData){
        this.healthData = healthData;
    }

    @NonNull
    @Override
    public HealthDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.display_health_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HealthDataAdapter.ViewHolder holder, int position) {
        final HealthDataModel hm = healthData.get(position);

        holder.babyWeight.setText(hm.getBabyWeight());
        holder.babyHeight.setText(hm.getBabyHeight());
    }

    @Override
    public int getItemCount() {
        return healthData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView babyWeight, babyHeight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            babyWeight = itemView.findViewById(R.id.babyWeight);
            babyHeight = itemView.findViewById(R.id.babyHeight);
        }
    }
}
