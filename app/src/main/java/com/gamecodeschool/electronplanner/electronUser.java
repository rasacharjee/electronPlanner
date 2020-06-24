package com.gamecodeschool.electronplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class electronUser extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseEvents;
    electronAdapter eAdapter;
    List<Event> eList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electron_user);
        recyclerView=findViewById(R.id.userRecyclerView);
        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
        eList=new ArrayList<>();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eList.clear();
                for(DataSnapshot eventSnapshot:dataSnapshot.getChildren()){
                    Event eventUser= eventSnapshot.getValue(Event.class);
                    eList.add(eventUser);
                }
                eAdapter=new electronAdapter(getApplicationContext(),eList);
                recyclerView.setAdapter(eAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"The error occurred is "+databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
