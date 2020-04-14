package com.example.indianfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
   // Resources res=getResources();

    ListView menuItems;
    private List<String> websites_list;
    private List<String> description_list;
    String [][] resuturantname={
            {"SaharS Kitchen","Kitchener","10","183 King St E, Kitchener, ON N2G 2K8","43.448310","-80.486328"},
            {"Empress Of India","Waterloo","8","34 King St S, Waterloo, ON N2J 2X5","43.488570", "-80.528120"},
            {"Vijays Indian Cuisine","Kitchener","8","380 Weber St W, Kitchener, ON N2H 4B3","43.462820","-80.500920"},
            {"Pranaam India Authentic Indian Restaurant","Cambridge","10","340 Woodlawn Rd W, Guelph, ON N1H 7K6","43.548031","-80.298637"},
            {"Grain of Salt","Cambridge","8","561 Hespeler Rd, Cambridge, ON N1R 6J4","43.403280 ","-80.325140"},
            {"Saffron Indian Cuisine","Cambridge","8","605 Hespeler Rd, Cambridge, ON N1R 6J3","43.404690","-80.325890"},
            {"Masala Bay","Waterloo","10","3B Regina St N, Waterloo, ON N2J 2W7","43.488570","-80.528120"},
            {"Shiris Kitchen","Waterloo","6","169 Lexington Ct unit # d, Waterloo, ON N2G 4R4","40.719730","-111.834440"}
    };
    //String [] websites=res.getStringArray(R.array.websites);
    int [] images={R.drawable.sahars_main,R.drawable.empress_main,R.drawable.vijay_main,R.drawable.pranaam_main,R.drawable.grain_main,R.drawable.saffron_main,R.drawable.masala_main,R.drawable.shiri_main};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //initialize Listview
        menuItems=(ListView)findViewById(R.id.listview);
        //set adapter
        //menuItems.setAdapter(new Adapter(this,resuturantname,images,websites));
        websites_list= Arrays.asList(getResources().getStringArray(R.array.websites));
        description_list= Arrays.asList(getResources().getStringArray(R.array.description));

        menuItems.setAdapter(new Adapter(this,resuturantname,images,websites_list,description_list));
    }
}