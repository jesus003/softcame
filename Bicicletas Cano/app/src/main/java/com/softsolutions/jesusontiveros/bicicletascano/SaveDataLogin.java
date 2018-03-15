package com.softsolutions.jesusontiveros.bicicletascano;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jesus Ontiveros on 15/03/2018.
 */

public class SaveDataLogin extends Application{
    private SharedPreferences sharedPref;
    public SaveDataLogin(Context context){;
        sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }
    public void guardaPreferencias(String nombre,String id_cliente){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nombre", nombre);
        editor.putString("id_cliente", id_cliente);
        editor.commit();
    }
    public ObjUsuario getPreferencias(){
        ObjUsuario usuario = new ObjUsuario();
        usuario.setNombre(sharedPref.getString("nombre", ""));
        usuario.setID(sharedPref.getString("id_cliente", ""));
        return usuario;
    }
    public void clearPreferencias(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("nombre");
        editor.remove("id_cliente");
        editor.commit();
    }
}
