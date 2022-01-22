package com.fooddrop.myapplicationdrawer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fooddrop.myapplicationdrawer.R;

public class CountryAdapter extends BaseAdapter {

    Context context;
    String countryList[];
    int flags[];
    LayoutInflater inflater;

    public CountryAdapter(Context context, String[] countryList, int[] flags, LayoutInflater inflater) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.country_list_raw, null);
        TextView country = view.findViewById(R.id.country_listView_id);
        ImageView icon = view.findViewById(R.id.country_icon);

        country.setText(countryList[i]);
        icon.setImageResource(flags[i]);

        return view;
    }
}
