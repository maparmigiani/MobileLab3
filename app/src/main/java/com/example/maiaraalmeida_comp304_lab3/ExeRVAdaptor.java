package com.example.maiaraalmeida_comp304_lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExeRVAdaptor extends RecyclerView.Adapter<ExeRVAdaptor.MyViewHolder> {

    private Context context;
    private ArrayList<String> exercises;
    private OnItemListener myListener;


    public ExeRVAdaptor(Context context, ArrayList<String> exercises) {
        this.context = context;
        this.exercises = exercises;
    }
    @Override
    public ExeRVAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exerc_info,parent,false);
        return new ExeRVAdaptor.MyViewHolder(view, myListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ExeRVAdaptor.MyViewHolder holder, int position) {

        holder.txtViewExercise.setText(exercises.get(position));
    }
    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtViewExercise;

        public MyViewHolder(@NonNull View itemView, OnItemListener listener) {
            super(itemView);
            txtViewExercise = itemView.findViewById(R.id.txtViewExercise);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener !=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
    //Creating OnItemClick Listener
    public interface OnItemListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemListener listener){
        myListener = listener;
    }

}