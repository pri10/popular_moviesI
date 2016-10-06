package com.example.priya.popular;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    //private AndroidGridAdapter androidGridAdapter;

    private String[] imageURLArray = new String[]{
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/z6BP8yLwck8mN9dtdYKkZ4XGa3D.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/7rfucKCjV01OEsGr9grXa34Aywd.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/1ZQVHkvOegv5wVzxD2fphcxl1Ba.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/9KQX22BeFzuNM66pBA6JbiaJ7Mi.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/6FxOPJ9Ysilpq0IgkrMJ7PubFhq.jpg",
            "https://image.tmdb.org/t/p/w185_and_h278_bestv2/lw0IqOSMsQcy1QnVIEIDppLmNwk.jpg"
            };



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);


        GridView gridview = (GridView) rootview.findViewById(R.id.gridview);

        AndroidGridAdapter androidGridAdapter = new AndroidGridAdapter(getContext(), R.layout.grid_view_item, imageURLArray);

        gridview.setAdapter(androidGridAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
            }
        });

        return rootview;
    }



}
