package com.example.florence.cours_list;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsFragment extends Fragment implements View.OnClickListener{


    EditText nom,prenom,tel;
    Contact c;
    Long id;

    public DetailsFragment(){}

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {


        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.details_fragment, container, false);


        TextView nom = (TextView) view.findViewById(R.id.nom);
        TextView prenom = (TextView) view.findViewById(R.id.prenom);
        TextView tel = (TextView) view.findViewById(R.id.tel);

        Button suppr_button=(Button)view.findViewById(R.id.supprimer);
        suppr_button.setOnClickListener((View.OnClickListener)this);

        Button modif_button=(Button)view.findViewById(R.id.modifier);
        modif_button.setOnClickListener((View.OnClickListener)this);

        id = getArguments().getLong("id");
        Activity activity = getActivity();
        Toast.makeText(activity,id.toString(), Toast.LENGTH_LONG).show();
        //c = Contact.findById(Contact.class,id);

        String Snom = getArguments().getString("nom");
        String Sprenom = getArguments().getString("prenom");
        String Stel = getArguments().getString("tel");



        nom.setText(Snom);
        prenom.setText(Sprenom);
        tel.setText(Stel);



        return view;

    }


    @Override
    public void onClick(View v) {
        //supprime le contact
        if (v.getId()==R.id.supprimer){
            c = Contact.findById(Contact.class,id);
            c.delete();
            Activity activity = getActivity();
            Toast.makeText(activity,"Contact supprimé",Toast.LENGTH_SHORT).show();
            activity.finish();
            //v.invalidate();
        }
        //affiche une activité modifier
        if (v.getId()==R.id.modifier)
        {

        }
    }
}
