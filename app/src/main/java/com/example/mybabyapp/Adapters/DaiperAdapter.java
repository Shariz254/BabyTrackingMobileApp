package com.example.mybabyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.Models.DaiperModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class DaiperAdapter extends RecyclerView.Adapter<DaiperAdapter.ViewHolder> {

    ArrayList<DaiperModel> Mdata = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daiper_list_output, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DaiperModel daiperModel = Mdata.get(position);
        holder.change_time.setText(daiperModel.getChange_time());
        holder.changeDay.setText(daiperModel.getChangeDay());
    }

    @Override
    public int getItemCount() {
        return Mdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView change_time, changeDay;
        private DaiperAdapter daiperAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            change_time = itemView.findViewById(R.id.changeTime);
            changeDay = itemView.findViewById(R.id.changeDay);
        }
    }

    public DaiperAdapter(ArrayList<DaiperModel> Mdata){
        this.Mdata = Mdata;
    }

}
