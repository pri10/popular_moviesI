package com.example.priya.popular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by priya on 9/26/2016.
 */

    public class AndroidGridAdapter extends ArrayAdapter<AndroidGridAdapter.GridImage> {

    private static final String LOGTAG=AndroidGridAdapter.class.getSimpleName();

    public AndroidGridAdapter(Context context, List<int[]> gridimage) {
        super(context, gridimage);
    }

    public class GridImage{
     int image;
    public GridImage(int image){
        this.image=image;

    }
}

    public View getView(int position, View convertView, ViewGroup parent){
        GridImage gridImage=getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_item, parent, false);
        }

        ImageView iconView = (ImageView) convertView.findViewById(R.id.imageview);
        iconView.setImageResource(gridImage.image);
        return convertView;

    }

}
