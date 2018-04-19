package com.example.florence.cours_list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i=0; i<20; i++)
            addItem("name"+i,"firstname"+i);

        adapter = new SimpleAdapter(this,
                data,
                R.layout.cell_content,
                new String[]{"name", "firstname"},
                new int[]{R.id.textView_name,
                        R.id.textView_firstname});

        setListAdapter(adapter);
    }

    private void addItem(String record_name, String record_fname) {
        HashMap<String,String> item = new HashMap<String,String>();
        item.put("name", record_name);
        item.put("firstname", record_fname);
        data.add(item);
    }

}
