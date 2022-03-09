package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.BathModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class BathAdapter extends RecyclerView.Adapter<BathAdapter.ViewHolder> {

    ArrayList<BathModel> Bdata = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bath_data_display, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BathModel bathModel = Bdata.get(position);

        holder.bathTime.setText(bathModel.getBathTime());
        holder.bathDay.setText(bathModel.getBathDay());
    }

    @Override
    public int getItemCount() {
        return Bdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView bathTime, bathDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bathTime = itemView.findViewById(R.id.bathTime);
            bathDay = itemView.findViewById(R.id.bathDay);
        }
    }

    public BathAdapter(ArrayList<BathModel> Bdata){
        this.Bdata = Bdata;
    }
}
