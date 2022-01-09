package com.fooddrop.myapplicationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

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

        // Listview on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(getApplicationContext(), listTitle.get(i) + " : " + listChild.get(listTitle.get(i)).get(i1), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(getApplicationContext(), listTitle.get(i) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(getApplicationContext(), listTitle.get(i) + " Closed" , Toast.LENGTH_SHORT).show();
            }
        });

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
        c1.add("We are your helper");
        c1.add("We are your helper");
        c1.add("We are your helper");

        List<String> c2 = new ArrayList<>();
        c2.add("We are your helper");
        c2.add("We are your helper");
        c2.add("We are your helper");

        List<String> c3 = new ArrayList<>();
        c3.add("We are your helper");
        c3.add("We are your helper");
        c3.add("We are your helper");

        listChild.put(listTitle.get(0), c1); // Header, Child data
        listChild.put(listTitle.get(1), c2);
        listChild.put(listTitle.get(2), c3);
    }
}