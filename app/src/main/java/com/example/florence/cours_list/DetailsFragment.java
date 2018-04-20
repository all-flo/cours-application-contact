package com.example.florence.cours_list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment{


    EditText nom,prenom,tel;
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

        String Snom = getArguments().getString("nom");
        String Sprenom = getArguments().getString("prenom");
        String Stel = getArguments().getString("tel");

        nom.setText(Snom);
        prenom.setText(Sprenom);
        tel.setText(Stel);


        return view;

    }




}
