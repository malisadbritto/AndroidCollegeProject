package com.example.indianfoodapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

public class ViewPagerAdapter extends PagerAdapter {


    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images={R.drawable.resturant1,R.drawable.resturant2,R.drawable.resturant3}
    ;
    String name;
    String address;
    String descrption;

    public ViewPagerAdapter (Context context,String name){
        this.context=context;
        this.name=name;


    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){

        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.imageslider_activity,null);

        ImageView imgslider=(ImageView)view.findViewById(R.id.imageViewSlider);
         TextView  txtViewname=(TextView)view.findViewById(R.id.textViewResturantName);
        Integer [] images_list;

        imgslider.setImageResource(images[position]);
        txtViewname.setText(name);

        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container,int position ,Object object){
        ViewPager vp=(ViewPager) container;
        View view=(View) object;
        vp.removeView(view);

    }
}
