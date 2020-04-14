package com.example.indianfoodapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class Adapter extends BaseAdapter {


    private  static LayoutInflater inflater=null;

    Context context;
    //Declare string array to get data from menuActivity
    String [][] resturantname;
    int[] images;
    private List<String> websites_list;
    private List<String> descrption_list;


    public Adapter(Context context,String [][] resturantname,int [] images,List<String> websites_list,List<String> descrption_list)
    {
        this.resturantname=resturantname;
        this.images=images;
        this.websites_list=websites_list;
        this.descrption_list=descrption_list;
        this.context=context;
        //this.websites=websites;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, final View convertView, ViewGroup parent) {
        final View v=inflater.inflate(R.layout.activity_menulist,null);
        TextView txtViewName=(TextView)v.findViewById(R.id.textViewName);
        TextView txtViewItem=(TextView)v.findViewById(R.id.textViewItem);
        TextView txtViewLocation=(TextView)v.findViewById(R.id.textViewlocation);

        ImageView itemImage=(ImageView) v.findViewById(R.id.imageViewItem);
        RatingBar rating=(RatingBar)v.findViewById(R.id.ratingBar);
        txtViewName.setText(resturantname[i][0]);
        //txtViewItem.setText(resturantname[i][1]);
        txtViewItem.setText(websites_list.get(i));
        txtViewLocation.setText(resturantname[i][1]);
        Log.i("Info","Description" +resturantname[i]);
        itemImage.setImageResource(images[i]);
        rating.setProgress(Integer.valueOf(resturantname[i][2]));

          Integer [] images={R.drawable.resturant1,R.drawable.resturant2,R.drawable.resturant3};
        final String  name=resturantname[i][0];
        final String address=resturantname[i][3];
        final String  Description=descrption_list.get(i);
        final String latitude=resturantname[i][4];
        final String longitude=resturantname[i][5];




        //itemImage.setTag(i);
        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DescriptionActivity.class);
                //intent.putExtra("Img",images[(Integer)v.getTag()]);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("description",Description);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);

                context.startActivity(intent);
            }
        });


        return v;
    }
}
