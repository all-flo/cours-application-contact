package com.example.florence.cours_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);

        Button valider_button=(Button)findViewById(R.id.valider);
        valider_button.setOnClickListener((View.OnClickListener)this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.valider)
        {

            Contact c;

            String n,p,t;
            EditText name = (EditText) findViewById(R.id.nom);
            n = name.getText().toString();

            EditText firstname = (EditText) findViewById(R.id.prenom);
            p = firstname.getText().toString();

            EditText tel = (EditText) findViewById(R.id.tel);
            t = tel.getText().toString();


            c = new Contact (n,p,t);
            c.save();

            finish();
        }
    }
}
