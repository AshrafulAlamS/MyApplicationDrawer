package com.fooddrop.myapplicationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fooddrop.myapplicationdrawer.databinding.BottomSheetPersistentBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class HelpActivity extends AppCompatActivity {

    //#1 Defining a BottomSheetBehavior instance
    private BottomSheetBehavior behavior;

    BottomSheetPersistentBinding binding;
    Button btnBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btnBottomSheet = findViewById(R.id.buttonBottomSheetPersistent);

        //#2 Initializing the BottomSheetBehavior
        View bottomSheet = findViewById(R.id.bottomSheet_id);
        behavior = BottomSheetBehavior.from(bottomSheet);

        //#3 Listening to State Changes of BottomSheet
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    btnBottomSheet.setText("Close Persistent Bottom Sheet");
                }else if(newState == BottomSheetBehavior.STATE_COLLAPSED){
                    btnBottomSheet.setText("Open Persistent Bottom Sheet");
                }else {
                    btnBottomSheet.setText("Persistent Bottom Sheet");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events

            }
        });
        behavior.removeBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        //#4 Changing the BottomSheet State on ButtonClick
        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else if(behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

            }
        });

    }
}