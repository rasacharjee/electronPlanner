package com.gamecodeschool.electronplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class electronAdmin extends AppCompatActivity {
    EditText etName,etDescription,etLocation;
    Spinner spinner;
    Button btnAdd;
    DatabaseReference databaseEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electron_admin);
        etName=findViewById(R.id.etName);
        etDescription=findViewById(R.id.etDescription);
        etLocation=findViewById(R.id.etLocation);
        spinner=findViewById(R.id.spinner);
        btnAdd=findViewById(R.id.btnAdd);
        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent();
            }
        });
    }
    private void addEvent(){
        String name=etName.getText().toString().trim();
        String description=etDescription.getText().toString().trim();
        String location=etLocation.getText().toString().trim();
        String eventType=spinner.getSelectedItem().toString();
        if(name.isEmpty() || description.isEmpty() || location.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
        }else{
            String id=databaseEvents.push().getKey();
            Event event=new Event(name,description,eventType,location);
            databaseEvents.child(id).setValue(event);
            Toast.makeText(getApplicationContext(),"Event Successfully added",Toast.LENGTH_SHORT).show();
        }
    }
}
