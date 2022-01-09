package com.fooddrop.myapplicationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;

public class DateTimeActivity extends AppCompatActivity {

    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        datePicker = findViewById(R.id.dp_id);



    }
}