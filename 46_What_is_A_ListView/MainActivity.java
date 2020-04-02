package com.example.application46;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] fruits= {"Apple","Orange","Peach","Mango","Banana","Apricots","Cherries","Dates"};

        ListAdapter myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits);
        ListView myListView = (ListView) findViewById(R.id.listView1);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String fruit = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this,fruit,Toast.LENGTH_LONG).show();
                    }
                }
        );


        ListAdapter myAdapter1 = new MyCustomAdapter(this,fruits);
        ListView myListView1 = (ListView) findViewById(R.id.listView2);
        myListView1.setAdapter(myAdapter1);

        myListView1.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        String fruit = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this,fruit,Toast.LENGTH_LONG).show();
                        return false;
                    }
                }
        );

    }
}
