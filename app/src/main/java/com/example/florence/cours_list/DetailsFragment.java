package com.example.florence.cours_list;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsFragment extends Fragment implements View.OnClickListener{

    EditText nom,prenom,tel;
    Contact c;
    Long id;
    TextView name,firstname,phone;

    public DetailsFragment(){}

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.details_fragment, container, false);

        name = (EditText) view.findViewById(R.id.nom);
        firstname = (EditText) view.findViewById(R.id.prenom);
        phone = (EditText) view.findViewById(R.id.tel);

        Button suppr_button=(Button)view.findViewById(R.id.supprimer);
        suppr_button.setOnClickListener((View.OnClickListener)this);

        Button modif_button=(Button)view.findViewById(R.id.modifier);
        modif_button.setOnClickListener((View.OnClickListener)this);

        id = getArguments().getLong("id");
        Activity activity = getActivity();
        Toast.makeText(activity,id.toString(), Toast.LENGTH_LONG).show();

        String Snom = getArguments().getString("nom");
        String Sprenom = getArguments().getString("prenom");
        String Stel = getArguments().getString("tel");

        name.setText(Snom);
        firstname.setText(Sprenom);
        phone.setText(Stel);

        return view;
    }


    @Override
    public void onClick(View v) {
        Activity activity = getActivity();
        c = Contact.findById(Contact.class,id);
        if (v.getId()==R.id.supprimer){
            c.delete();
            Toast.makeText(activity,"Contact supprimé",Toast.LENGTH_SHORT).show();
            activity.finish();
        }
        if (v.getId()==R.id.modifier)
        {
            c.setNom(name.getText().toString());
            c.setPrenom(firstname.getText().toString());
            c.setTelephone(phone.getText().toString());

            c.save();
            Toast.makeText(activity,"Contact modifié",Toast.LENGTH_SHORT).show();
            activity.finish();
        }
    }
}
