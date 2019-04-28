package com.example.android.feedbackapp_ipscollege;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.Rating;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Mainpage extends AppCompatActivity {

    String[] facultynames = {" Vineet Raj" ,"Purushottam Verma" ,"karunendra verma" , "Pragya Sharma","Neha sharma","Manvendra Gautam"};
    int[] facultyimage = {R.drawable.vineet , R.drawable.puru , R.drawable.karu,R.drawable.pragya , R.drawable.logo , R.drawable.mama};

    Toolbar toolbar;
    ListView listView;
    ConstraintLayout layout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.theme:

                layout.setBackgroundColor(Color.parseColor("#10A881"));
                return true;

            case R.id.aboutus:
                return true;

                default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext() , Main2page.class);
                intent.putExtra("name" , facultynames[position]);
                intent.putExtra("images" , facultyimage[position]);
                startActivity(intent);
            }
        });

    }

        private class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {

           return facultyimage.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.listviewstuff,null);
            TextView name = view1.findViewById(R.id.listview1);
            ImageView image = view1.findViewById(R.id.imageView2);

            name.setText(facultynames[position]);
            image.setImageResource(facultyimage[position]);

            return view1;
        }
    }
}

