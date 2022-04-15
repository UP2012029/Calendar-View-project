package com.example.calenderview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class eventRecyclerAdapter extends RecyclerView.Adapter<eventRecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<events> arrayList;

    public eventRecyclerAdapter(Context context, ArrayList<events> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showevent_layout, parent, false);

        return new MyViewHolder(view);
    }

    //event details and deleting functions
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        events Events = arrayList.get(position);
        holder.Event.setText(Events.getEvent());
        holder.DateTxt.setText(Events.getDate());
        holder.Time.setText(Events.getTime());
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCalendarEvent(Events.getEvent(), Events.getDate(), Events.getTime());
                arrayList.remove(position);
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView DateTxt, Event, Time;
        Button Delete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            DateTxt = itemView.findViewById(R.id.event_date);
            Event = itemView.findViewById((R.id.event_name));
            Time = itemView.findViewById(R.id.event_time);
            Delete = itemView.findViewById(R.id.Delete);

        }
    }

    private void deleteCalendarEvent(String event, String date, String time){
        //dphelper code which deletes events
    }
}
