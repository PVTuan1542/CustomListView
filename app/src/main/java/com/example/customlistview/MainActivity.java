package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook", "Whatsapp","Youtube", "Tiktok", "Instagram", "Twitter"};

    String mDescription[] = {"2,7 tỷ người dùng", "2 tỷ người dùng",  "1,9 tỷ người dùng",
                                "1,5 tỷ người dùng", "1 tỷ người dùng","330 triệu người dùng"};

    int images[] = {R.drawable.facebook, R.drawable.whatsapp,R.drawable.youtube,
                                R.drawable.tiktok, R.drawable.instagram, R.drawable.twitter};

    //Paste some images on drawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //now create adapter my class
        MyAdapter myAdapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Facebook description", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(MainActivity.this, "Whatsapp description", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(MainActivity.this, "Youtube description", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(MainActivity.this, "Tiktok description", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(MainActivity.this, "Instagram description", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(MainActivity.this, "Twitter description", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {//ArrayAdapter<String>
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        @NonNull
        @Override
        public Context getContext() {
            return context;
        }

        public String[] getrTitle() {
            return rTitle;
        }

        public String[] getrDescription() {
            return rDescription;
        }

        public int[] getrImgs() {
            return rImgs;
        }

        MyAdapter(Context c, String title[], String description[], int[] Imgs) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = Imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           // LayoutInflater  layoutInflater = LayoutInflater.from(context);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.img);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            //now ser our resources on views

                images.setImageResource(rImgs[position]);
                myTitle.setText(rTitle[position]);
                myDescription.setText(rDescription[position]);



            return row;
        }


    }
}
