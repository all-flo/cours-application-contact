package com.example.florence.cours_list;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadContactActivity extends AppCompatActivity {



        SimpleAdapter adapter;
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.read_contact_activity);
            final List<Contact> contacts = Contact.listAll(Contact.class);
            for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                String nomContact = c.getNom();
                String prenomContact = c.getPrenom();
                addItem(nomContact, prenomContact);
            }
            final ListView liste = (ListView) findViewById(R.id.liste);
            adapter = new SimpleAdapter(this, data, R.layout.cell_content,
                    new String[]{"name", "firstname"}, new int[]{R.id.textView_name,
                    R.id.textView_firstname});
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3) {
                        Contact c = contacts.get(position);
                        String nomContact = c.getNom();
                        String prenomContact = c.getPrenom();
                        String tel = c.getTelephone();
                        Toast.makeText(ReadContactActivity.this,
                                prenomContact + nomContact + tel, Toast.LENGTH_LONG).show();
                        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                        Intent intent = new Intent(ReadContactActivity.this, DetailsActivity.class);
                        intent.putExtra("Contact", c);
                        startActivity(intent);
                        }

                        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
                            if (findViewById(R.id.container) != null) {
                                //clearBackStack();
                                DetailsFragment DFragment = new DetailsFragment();
                                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                                //transaction.add(R.id.container, DFragment);
                                transaction.replace(R.id.container, DFragment);
                                transaction.addToBackStack(null);
                                transaction.commit();
                                String id = c.getId().toString();
                                Bundle bundle = new Bundle();
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


    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
    }