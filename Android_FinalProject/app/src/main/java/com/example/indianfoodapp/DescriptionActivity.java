package com.example.indianfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class DescriptionActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        viewPager=(ViewPager) findViewById(R.id.viewpager);

        // ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        final String name= getIntent().getStringExtra("name");
        String address= getIntent().getStringExtra("address");
        String description= getIntent().getStringExtra("description");
        final String latitude= getIntent().getStringExtra("latitude");
        final String longtitude= getIntent().getStringExtra("longitude");
        TextView  txtViewaddress=(TextView)findViewById(R.id.textViewAddress);
        TextView  txtViewdescription=(TextView)findViewById(R.id.textViewDescription);
        txtViewaddress.setText(address);

        txtViewdescription.setText(description);
        viewPager.setAdapter(new ViewPagerAdapter(this,name));
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);
        txtViewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DescriptionActivity.this,MapsActivity.class);
                i.putExtra("latitude",latitude);
                i.putExtra("longitude",longtitude);
                i.putExtra("name",name);
                startActivity(i);
            }
        });
    }


    //Method to slide the images
    public  class MyTimerTask extends TimerTask{


        @Override
        public void run() {
            DescriptionActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
}
