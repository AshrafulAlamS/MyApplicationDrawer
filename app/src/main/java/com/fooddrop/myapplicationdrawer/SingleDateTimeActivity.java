package com.fooddrop.myapplicationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.github.florent37.singledateandtimepicker.dialog.DoubleDateAndTimePickerDialog;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class SingleDateTimeActivity extends AppCompatActivity {
    private static final String TAG = "SingleDateTimeActivity";

    Context context;
    SingleDateAndTimePicker singleDateAndTimePicker_1, singleDateAndTimePicker_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_date_time);

        //singleDateAndTimePicker_1 = findViewById(R.id.single_day_picker_id_1);
        singleDateAndTimePicker_2 = findViewById(R.id.single_date_picker_id_2);

        new SingleDateAndTimePickerDialog.Builder(context)
                //.bottomSheet()
                //.curved()
                //.stepSizeMinutes(15)
                //.displayHours(false)
                //.displayMinutes(false)
                //.todayText("aujourd'hui")
                .displayListener(new SingleDateAndTimePickerDialog.DisplayListener() {
                    @Override
                    public void onDisplayed(SingleDateAndTimePicker picker) {
                        // Retrieve the SingleDateAndTimePicker
                        Date currentDate = picker.getDate();
                        Toast.makeText(context, "It's "+currentDate, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onDisplayed: "+currentDate);

                    }

                    /*@Override
                    public void onClosed(SingleDateAndTimePicker picker) {
                        // On dialog closed
                    }*/
                })
                .title("Simple")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {
                        Toast.makeText(context, "Date Selected:"+date.toString(), Toast.LENGTH_SHORT).show();
                    }
                }).display();



        new DoubleDateAndTimePickerDialog.Builder(context)
                //.bottomSheet()
                //.curved()
                //.stepSizeMinutes(15)
                .title("Double")
                .tab0Text("Depart")
                .tab1Text("Return")
                .backgroundColor(Color.BLACK)
                .mainColor(Color.GREEN)
                .listener(new DoubleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(List<Date> dates) {
                        TimeZone tz = TimeZone.getTimeZone("Asia/Dhaka");
                        Log.d(TAG, "onDateSelected: "+tz);
                    }
                }).display();

        new SingleDateAndTimePickerDialog.Builder(this)
                .bottomSheet()
                .curved()
                .displayMinutes(false)
                .displayHours(false)
                .displayDays(false)
                .displayMonth(true)
                .displayYears(true)
                .displayDaysOfMonth(true)
                .display();


    }

}