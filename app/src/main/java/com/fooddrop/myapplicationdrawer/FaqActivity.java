package com.fooddrop.myapplicationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.fooddrop.myapplicationdrawer.adapter.FaqExListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    FaqExListAdapter listAdapter;
    List<String> listTitle;
    HashMap<String, List<String>> listChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // get the listview
        expandableListView = findViewById(R.id.elv_faq_id);

        // preparing list data
        prepareListData();

        listAdapter = new FaqExListAdapter(this, listTitle, listChild);

        // setting list adapter
        expandableListView.setAdapter(listAdapter);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listTitle = new ArrayList<>();
        listChild = new HashMap<String, List<String>>();

        // Adding child data
        listTitle.add("Who are we?");
        listTitle.add("What is our goal?");
        listTitle.add("Who you will be benefited?");

        // Adding child data
        List<String> c1 = new ArrayList<>();
        c1.add("Wre are your helper");
        c1.add("Wre are your helper");
        c1.add("Wre are your helper");

        List<String> c2 = new ArrayList<>();
        c2.add("Wre are your helper");
        c2.add("Wre are your helper");
        c2.add("Wre are your helper");

        List<String> c3 = new ArrayList<>();
        c3.add("Wre are your helper");
        c3.add("Wre are your helper");
        c3.add("Wre are your helper");

        listChild.put(listTitle.get(0), c1); // Header, Child data
        listChild.put(listTitle.get(1), c2);
        listChild.put(listTitle.get(2), c3);
    }
}