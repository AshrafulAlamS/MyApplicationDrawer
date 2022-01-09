package com.fooddrop.myapplicationdrawer.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fooddrop.myapplicationdrawer.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<String> historyTitle;
    private Context context;

    AdapterListener adapterListener;

    public GalleryAdapter(ArrayList<String> historyTitle, Context context) {
        this.historyTitle = historyTitle;
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        String title = historyTitle.get(position);
        holder.title_tv.setText(title);
    }

    @Override
    public int getItemCount() {
        return historyTitle.size();
    }

    public interface AdapterListener{
        void onItemClick(int position);
    }


    public class GalleryViewHolder extends RecyclerView.ViewHolder{
        TextView title_tv;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            title_tv = itemView.findViewById(R.id.tv_Header);
        }
    }
}
