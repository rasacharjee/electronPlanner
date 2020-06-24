package com.gamecodeschool.electronplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class electronAdapter extends RecyclerView.Adapter<electronViewHolder> {
    Context context;
    List<Event> eList;

    public electronAdapter() {
    }
    public electronAdapter(Context context, List<Event> eList) {
        this.context = context;
        this.eList = eList;
    }

    @NonNull
    @Override
    public electronViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        return new electronViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull electronViewHolder holder, int position) {
     Event current=eList.get(position);
     String eventName=current.getEventName().trim();
     String eventType=current.getEventType().trim();
     String eventDescription=current.getEventDescription().trim();
     String eventLocation=current.getEventLocation().trim();
     holder.eventNameUser.setText(eventName);
     holder.eventTypeUser.setText(eventType);
     holder.eventDescriptionUser.setText(eventDescription);
     holder.eventLocationUser.setText(eventLocation);
    }

    @Override
    public int getItemCount() {
        return eList.size();
    }
}
