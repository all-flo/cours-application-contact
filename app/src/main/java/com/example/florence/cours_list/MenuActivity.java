package com.example.florence.cours_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button add_button=(Button)findViewById(R.id.add);
        add_button.setOnClickListener((View.OnClickListener)this);

        Button read_button=(Button)findViewById(R.id.read);
        read_button.setOnClickListener((View.OnClickListener)this);
    }


    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.add)
        {
            //Toast.makeText(this,"Passage sur InscriptionActivity", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AddContactActivity.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.read)
        {
            //Toast.makeText(this,"Passage sur InscriptionActivity", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ReadContactActivity.class);
            startActivity(intent);
        }
    }
}
