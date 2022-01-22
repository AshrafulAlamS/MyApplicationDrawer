package com.fooddrop.myapplicationdrawer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.fooddrop.myapplicationdrawer.R;
import com.google.android.material.textfield.TextInputLayout;

public class EditTextActivity extends AppCompatActivity {

    TextInputLayout nameTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        nameTextInputLayout = findViewById(R.id.outlinedTextField);

        String nameString = nameTextInputLayout.getEditText().getText().toString();
        nameTextInputLayout.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}