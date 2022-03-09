package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.ScheduleAppointmentModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class ViewAppointmentAdapter extends RecyclerView.Adapter<ViewAppointmentAdapter.ViewHolder> {

    ArrayList<ScheduleAppointmentModel> appointmentData = new ArrayList<>();
    Context context;

    public ViewAppointmentAdapter(ArrayList<ScheduleAppointmentModel> appointmentData){
        this.appointmentData = appointmentData;
    }


    @NonNull
    @Override
    public ViewAppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_display_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAppointmentAdapter.ViewHolder holder, int position) {
        final ScheduleAppointmentModel sam = appointmentData.get(position);

        holder.babyName.setText(sam.getBabyName());
        holder.babyAge.setText(sam.getBabyAge());
        holder.babySymptoms.setText(sam.getBabySymptoms());
        holder.timeFrom.setText(sam.getTimeFrom());
        holder.dayFrom.setText(sam.getDayFrom());
    }

    @Override
    public int getItemCount() {
        return appointmentData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView babyName, babyAge, babySymptoms, timeFrom, dayFrom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            babyName = itemView.findViewById(R.id.babyName);
            babyAge = itemView.findViewById(R.id.babyAge);
            babySymptoms = itemView.findViewById(R.id.babySymptoms);
            timeFrom = itemView.findViewById(R.id.timeFrom);
            dayFrom = itemView.findViewById(R.id.dayFrom);
        }
    }
}
