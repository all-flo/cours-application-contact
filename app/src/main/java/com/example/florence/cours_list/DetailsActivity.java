package com.example.florence.cours_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    TextView name, firstname,phone;
    Contact c;
    Long id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Button read_button=(Button)findViewById(R.id.modifier);
        read_button.setOnClickListener((View.OnClickListener)this);


        Button suppr_button=(Button)findViewById(R.id.supprimer);
        suppr_button.setOnClickListener((View.OnClickListener)this);

        Button modif_button=(Button)findViewById(R.id.modifier);
        modif_button.setOnClickListener((View.OnClickListener)this);

       //c = (Contact) getIntent().getSerializableExtra("Contact");
        id = (Long) getIntent().getLongExtra("contactid", 0);
        c = Contact.findById(Contact.class,id);

        name = (EditText) findViewById(R.id.nom);
        firstname = (EditText) findViewById(R.id.prenom);
        phone = (EditText) findViewById(R.id.tel);

        name.setText(c.getNom());
        firstname.setText(c.getPrenom());
        phone.setText(c.getTelephone());
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.modifier){

            c.setNom(name.getText().toString());
            c.setPrenom(firstname.getText().toString());
            c.setTelephone(phone.getText().toString());


            c.update();
            Toast.makeText(getApplicationContext(),"Contact modifié",Toast.LENGTH_SHORT).show();
            finish();

        }
        if (v.getId()==R.id.supprimer){

            c.delete();
            Toast.makeText(getApplicationContext(),"Contact supprimé",Toast.LENGTH_SHORT).show();
            finish();
            //v.invalidate();
        }
    }




}
