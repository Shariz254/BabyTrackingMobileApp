package com.example.mybabyapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.ProfileModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    ArrayList<ProfileModel> profileData = new ArrayList<>();
    Context context;

    public ProfileAdapter(ArrayList<ProfileModel> profileData) {
        this.profileData = profileData;
    }

    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {
        final ProfileModel profileModel = profileData.get(position);

        holder.mbabyName.setText(profileModel.getBabyName());
        holder.mbabyDOB.setText(profileModel.getBabyDob());
        holder.mbabyGender.setText(profileModel.getBabyGender());
    }

    @Override
    public int getItemCount() {
        return profileData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mbabyName, mbabyDOB, mbabyGender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mbabyName = itemView.findViewById(R.id.babyName);
            mbabyDOB = itemView.findViewById(R.id.babyDOB);
            mbabyGender = itemView.findViewById(R.id.babyGender);
        }
    }

}
