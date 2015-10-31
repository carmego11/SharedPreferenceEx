package com.carmego_company.sharedpreferenceex;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Login login;
    Delete delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        boolean hayUsuario = sharedPref.getBoolean("User", false);

        if (hayUsuario) {

            login = new Login();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, login, "Login").commit();

        } else {

            delete = new Delete();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, delete, "Delete").commit();

        }
    }


    public void saveName(View v){
        EditText edtTxtNombre=(EditText)login.getView().findViewById(R.id.editTextName);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Name", edtTxtNombre.getText().toString());
        editor.putBoolean("User", true);
        editor.apply();

        if(delete==null){
            delete =new Delete();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, delete, "Delete").commit();
    }

    public void eraseName(View v) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("User");
        editor.putBoolean("User", false);
        editor.apply();

        if(login==null){
            login = new Login();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, login, "Login").commit();

    }

}
