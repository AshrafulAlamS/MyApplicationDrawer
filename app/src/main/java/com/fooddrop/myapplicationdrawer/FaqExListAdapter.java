package com.fooddrop.myapplicationdrawer;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class FaqExListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listTitle;
    private HashMap<String, List<String>> listChild;

    public FaqExListAdapter(Context context, List<String> listTitle, HashMap<String, List<String>> listChild) {
        this.context = context;
        this.listTitle = listTitle;
        this.listChild = listChild;
    }

    @Override
    public int getGroupCount() {
        return this.listTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.listChild.get(this.listTitle.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.listTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listChild.get(this.listTitle.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String header = (String) getGroup(i);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_elv_faq, null);
        }
        TextView tvHeader = view.findViewById(R.id.tv_parent_faq_id);
        tvHeader.setTypeface(null, Typeface.BOLD);
        tvHeader.setText(header);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(i, i1);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_elv_faq, null);
        }
        TextView tvChild = view.findViewById(R.id.tvChild_faq_id);
        tvChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
