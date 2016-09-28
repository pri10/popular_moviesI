package com.example.priya.popular;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private AndroidGridAdapter androidGridAdapter;

    int[] gridimage={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment_main, container, false);

        androidGridAdapter=new AndroidGridAdapter(getActivity(), Arrays.asList(gridimage));

        GridView gridView= (GridView) rootview.findViewById(R.id.gridview);
        gridView.setAdapter(androidGridAdapter);
        return rootview;
    }
}
