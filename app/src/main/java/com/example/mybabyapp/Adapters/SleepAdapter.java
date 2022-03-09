package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.FeedingModel;
import com.example.mybabyapp.Models.SleepModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class SleepAdapter extends RecyclerView.Adapter<SleepAdapter.ViewHolder> {

    ArrayList<SleepModel> sleepData = new ArrayList<>();
    Context context;

    public SleepAdapter(ArrayList<SleepModel> sleepData) {
        this.sleepData = sleepData;
    }

    @NonNull
    @Override
    public SleepAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SleepAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.display_sleep_logs, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SleepAdapter.ViewHolder holder, int position) {

        final SleepModel sleepModel = sleepData.get(position);

        holder.sleepTime.setText(sleepModel.getSleep_time());
        holder.wakeUpTime.setText(sleepModel.getWakeUp_time());

    }

    @Override
    public int getItemCount() {
        return sleepData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView sleepTime, wakeUpTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sleepTime = itemView.findViewById(R.id.sleepTime);
            wakeUpTime = itemView.findViewById(R.id.wakeUpTime);
        }
    }
}
