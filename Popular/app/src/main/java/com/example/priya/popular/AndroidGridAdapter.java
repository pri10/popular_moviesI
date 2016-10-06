package com.example.priya.popular;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * Created by priya on 9/26/2016.
 */

public class AndroidGridAdapter extends ArrayAdapter {
    private String[] imageURLArray;
    private LayoutInflater inflater;


    public AndroidGridAdapter(Context context, int resource, String[] imageArray) {
        super(context, resource, imageArray);

        // TODO Auto-generated constructor stub
        inflater = ((Activity)context).getLayoutInflater();
        imageURLArray = imageArray;
    }
    private static class ViewHolder {

        ImageView imageView;
        public String imageURL;
        public Bitmap bitmap;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        ViewHolder viewHolder=null;
        if (convertView == null) {
            convertView=inflater.inflate(R.layout.grid_view_item,null);
            viewHolder = new ViewHolder();

            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imageview);

            convertView.setTag(viewHolder);

        }



        viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.imageURL = imageURLArray[position];

        new DownloadAsyncTask().execute();

        return convertView;

    }

    private class DownloadAsyncTask extends AsyncTask<String, Void, String> {



        @Override

        protected String doInBackground(String... params) {

            // TODO Auto-generated method stub

            //load image directly



            /*
            try {

                URL imageURL = new URL(viewHolder.imageURL);

                viewHolder.bitmap = BitmapFactory.decodeStream(imageURL.openStream());

            } catch (IOException e) {

                // TODO: handle exception

                Log.e("error", "Downloading Image Failed");

               viewHolder.bitmap = null;

            }
            */
            try{
            URL url = new URL("http://api.themoviedb.org/3/movie/550?api_key=5fabb477f70d2445251714d9911e933f");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader br = null;

                br = new BufferedReader(new InputStreamReader((con.getInputStream())));


            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            return null;
        } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

return null;
        }




 }



}