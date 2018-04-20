package com.example.florence.cours_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Contact c = (Contact) getIntent().getSerializableExtra("Contact");

        EditText nom = (EditText) findViewById(R.id.nom);
        EditText prenom = (EditText) findViewById(R.id.prenom);

        nom.setText(c.getNom());
        prenom.setText(c.getPrenom());
    }

}
