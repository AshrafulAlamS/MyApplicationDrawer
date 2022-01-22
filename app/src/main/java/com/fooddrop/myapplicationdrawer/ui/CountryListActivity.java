package com.fooddrop.myapplicationdrawer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fooddrop.myapplicationdrawer.R;
import com.fooddrop.myapplicationdrawer.adapter.CountryAdapter;

public class CountryListActivity extends AppCompatActivity {

    ListView listView;

    String[] countryArray = {"Bangladesh", "India", "Pakistan", "Nepal", "Bhutan", "Japan"
            , "Italy", "Dubai", "Franc", "Korea", "America", "London", "Paris", "Brazil"
            , "Italy", "Dubai", "Franc", "Korea", "America", "London", "Paris", "Brazil"};
    int[] flags = {R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag,
            R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag,
            R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag,
            R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag, R.drawable.ic_flag };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        listView = findViewById(R.id.country_listView_id);

        //ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.country_list_raw, countryArray);

        CountryAdapter adapter = new CountryAdapter(getApplicationContext(), countryArray, flags, getLayoutInflater());
        listView.setAdapter(adapter);

    }
}