package com.example.multimediaps2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = findViewById(R.id.listView1);
        //MyListAdapter adapter=new MyListAdapter(this, maintitle, imgid);
      MyListAdapter adapter=new MyListAdapter(this, maintitle,subtitle, imgid);
        listView1.setAdapter(adapter);                                   //przypisanie adaptera do listy
    }
    public Integer[] imgid={
            R.drawable.cat1,R.drawable.cat2,
            R.drawable.cat3,R.drawable.cat4,
            R.drawable.cat5
    };
    public String[] maintitle ={
            "Mruczek","Oczko",
            "Ogonek","Nozka",
            "Gryzek",
    };

    public String[] subtitle ={
            "Lubi mruczec","Jest slepy",
            "Macha ogonem","Lubi skakac",
            "Jest agresywny",
    };





    public class MyListAdapter extends ArrayAdapter<String> {       //adapter

        private final Activity context;
        private final String[] maintitle;
        private final Integer[] imgid;
        private final  String[] subtitle;



        public MyListAdapter(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid) {
            super(context, R.layout.row, maintitle);
            this.context=context;
            this.maintitle=maintitle;
            this.imgid=imgid;
            this.subtitle= subtitle;
                                          //przypisanie adaptera do listy
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.row, null,true);

            TextView titleText = (TextView) rowView.findViewById(R.id.title);
            TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

            titleText.setText(maintitle[position]);
            subtitleText.setText(subtitle[position]);
            imageView.setImageResource(imgid[position]);

            return rowView;

        };


    }

}
