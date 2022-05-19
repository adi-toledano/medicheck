package com.example.medicheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddMedicine extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinner;
    private Spinner spinner2;
    private static final String[] paths = {"תרופה 1", "תרופה 3", "תרופה 2"};
    private static final String[] medicine = {"קופסה חכמה 1", "קופסה חכמה 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddMedicine.this,
                android.R.layout.simple_spinner_item, paths);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(AddMedicine.this,
                android.R.layout.simple_spinner_item, medicine);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        Button pair = findViewById(R.id.button_pair);
        Button add = findViewById(R.id.button_add);
        pair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), connect_with_arduino.class);//AppListActivity
                startActivity(i);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), log_in_activity.class);//AppListActivity
                startActivity(i);
            }
        });
    }
        @Override
        public void onItemSelected (AdapterView < ? > parent, View v,int position, long id){

            switch (position) {
                case 0:
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    break;

            }
        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){
            // TODO Auto-generated method stub
        }

    }