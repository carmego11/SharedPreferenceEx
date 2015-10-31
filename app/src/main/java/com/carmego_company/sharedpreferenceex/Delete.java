package com.carmego_company.sharedpreferenceex;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Delete extends Fragment {

    TextView txtVwHola;

    public Delete(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View delete=inflater.inflate(R.layout.activity_delete,container,false);

        return delete;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        txtVwHola = (TextView)getView().findViewById(R.id.txtVwHello);
        String nombre = sharedPref.getString("Name", "").toString();
        txtVwHola.setText("Hola "+ nombre);

    }
}
