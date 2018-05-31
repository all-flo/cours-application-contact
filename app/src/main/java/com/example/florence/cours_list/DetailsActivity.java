package com.example.florence.cours_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    TextView name, firstname,phone;
    Contact c;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Button read_button=(Button)findViewById(R.id.modifier);
        read_button.setOnClickListener((View.OnClickListener)this);


        c = (Contact) getIntent().getSerializableExtra("Contact");

        name = (TextView) findViewById(R.id.nom);
        firstname = (TextView) findViewById(R.id.prenom);
        phone = (TextView) findViewById(R.id.tel);

        name.setText(c.getNom());
        firstname.setText(c.getPrenom());
        phone.setText(c.getTelephone());
    }

    @Override
    public void onClick(View v) {
        String nom,prenom,tel;
        if (v.getId()==R.id.modifier){
            name = (EditText) findViewById(R.id.nom);
            nom = name.getText().toString();
            firstname = (EditText) findViewById(R.id.prenom);
            prenom = firstname.getText().toString();
            phone = (EditText) findViewById(R.id.tel);
            tel = phone.getText().toString();

            Contact temp= new Contact();
            // = Contact.findById(Contact.class,c.getId());

            temp.setNom(nom);
            temp.setPrenom(prenom);
            temp.setTelephone(tel);
            temp.update();
        }
        if (v.getId()==R.id.suppr){
            //Contact temp = Contact.findById(Contact.class,c.getId());
            c.delete();
        }






    }
}
