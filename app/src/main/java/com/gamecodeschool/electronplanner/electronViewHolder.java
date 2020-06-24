package com.gamecodeschool.electronplanner;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class electronViewHolder extends RecyclerView.ViewHolder {
    TextView eventNameUser,eventTypeUser,eventDescriptionUser,eventLocationUser;
    public electronViewHolder(@NonNull View itemView) {
        super(itemView);
        eventNameUser=itemView.findViewById(R.id.eventNameUser);
        eventTypeUser=itemView.findViewById(R.id.eventTypeUser);
        eventDescriptionUser=itemView.findViewById(R.id.eventDescriptionUser);
        eventLocationUser=itemView.findViewById(R.id.eventLocationUser);
    }
}
