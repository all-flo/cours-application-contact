package com.example.florence.cours_list;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadContactActivity extends AppCompatActivity implements View.OnClickListener {


    TextView critereTV;
    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    List<Contact> contacts = new ArrayList<>();
    ListView liste;
    Long idsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_contact_activity);

        Button add_button=(Button)findViewById(R.id.search);
        add_button.setOnClickListener((View.OnClickListener)this);
        critereTV = (EditText) findViewById(R.id.critere);

        contacts = Contact.listAll(Contact.class);

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            String nomContact = c.getNom();
            String prenomContact = c.getPrenom();
            addItem(nomContact, prenomContact);
        }

        liste = (ListView) findViewById(R.id.liste);
        adapter = new SimpleAdapter(this, data, R.layout.cell_content,
                new String[]{"name", "firstname"}, new int[]{R.id.textView_name,
                R.id.textView_firstname});
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Contact c = contacts.get(position);
                if (liste.getAdapter().getCount()!=contacts.size()) c = Contact.findById(Contact.class,idsearch);
                if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                    Intent intent = new Intent(ReadContactActivity.this, DetailsActivity.class);
                    intent.putExtra("contactid", c.getId());
                    startActivity(intent);
                }

                if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
                    if (findViewById(R.id.container) != null) {
                        DetailsFragment DFragment = new DetailsFragment();
                        FragmentTransaction transaction =getFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, DFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Bundle bundle = new Bundle();
                        bundle.putLong("id",c.getId());

                        bundle.putString("nom", c.getNom());
                        bundle.putString("prenom", c.getPrenom());
                        bundle.putString("tel", c.getTelephone());

                        DFragment.setArguments(bundle);
                    }
                }
            }
        });
    }



    private void addItem(String record_name, String record_fname) {
        HashMap<String,String> item = new HashMap<String,String>();
        item.put("name", record_name);
        item.put("firstname", record_fname);
        data.add(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public void onClick(View v) {
       critereTV = findViewById(R.id.critere);
        if (v.getId()==R.id.search){
            data.clear();
            for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                String nomContact = c.getNom();
                String prenomContact = c.getPrenom();
                if(prenomContact.contains(critereTV.getText().toString()) ||
                        nomContact.contains(critereTV.getText().toString())) {
                    addItem(nomContact, prenomContact);
                    idsearch = c.getId();
                }
            }
            adapter = new SimpleAdapter(this, data, R.layout.cell_content,
                    new String[]{"name", "firstname"}, new int[]{R.id.textView_name,
                    R.id.textView_firstname});
            liste.setAdapter(adapter);
            contacts.clear();
            contacts = Contact.listAll(Contact.class);
        }
    }
}

