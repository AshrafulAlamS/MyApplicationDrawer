package com.fooddrop.myapplicationdrawer.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fooddrop.myapplicationdrawer.R;
import com.fooddrop.myapplicationdrawer.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    RecyclerView gallery_rv;
    GalleryAdapter galleryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        gallery_rv = view.findViewById(R.id.rv_gallery_id);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Java");
        titleList.add("Html");
        titleList.add("CSS");
        titleList.add("JSX");
        titleList.add("XML");
        titleList.add("SCSS");
        titleList.add("MUI");
        titleList.add("Html");
        titleList.add("CSS");
        titleList.add("JSX");
        titleList.add("XML");
        titleList.add("SCSS");
        titleList.add("MUI");

        gallery_rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        galleryAdapter = new GalleryAdapter(titleList, getActivity());
        gallery_rv.setAdapter(galleryAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
