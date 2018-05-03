package com.softsolutions.jesusontiveros.bicicletascano;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {



    EditText txtUsuario,txtPass;

    ObjUsuario objUsuario = new ObjUsuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtPass=(EditText)findViewById(R.id.txtPass);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);

    }

    public  void validLogin(View v){
        if (isOnlineNet()== true) {
            if (!txtUsuario.getText().toString().equals("") && !txtUsuario.getText().toString().equals("")) {
                RequestQueue queue = Volley.newRequestQueue(this);

                String url = "http://wcf.softcame.net/login.php?user=" + txtUsuario.getText().toString() + "&pass=" + txtPass.getText().toString();
                JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // display response
                                try {
                                    JSONArray valid = response.getJSONArray("login");
                                    JSONObject obj = valid.getJSONObject(0);
                                    if (Integer.parseInt(obj.getString("id_cliente")) > 0) {
                                        // SaveDataLogin preferencias = new SaveDataLogin(login.this);
                                        // preferencias.guardaPreferencias(obj.getString("nombre"),obj.getString("id_cliente"));
                                        Intent i = new Intent(login.this, Inicio.class);
                                        i.putExtra("nombre", obj.getString("nombre"));
                                        i.putExtra("id", obj.getString("id_cliente"));
                                        FirebaseMessaging.getInstance().subscribeToTopic(obj.getString("id_cliente"));
                                        startActivity(i);
                                        finish();
                                    } else {
                                        Toast.makeText(login.this, "Usuario o Contraseña erroneos", Toast.LENGTH_SHORT).show();
                                        txtPass.setText("");
                                        txtUsuario.setText("");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.getMessage());
                            }
                        }
                );
                queue.add(getRequest);
            } else {
                Toast.makeText(login.this, "Debe ingresar todos los datos.", Toast.LENGTH_SHORT).show();
                txtPass.setText("");
                txtUsuario.setText("");
            }
        }else {
            Toast.makeText(login.this, "No se dispone de una conexion a internet.", Toast.LENGTH_SHORT).show();
        }
    }
    public Boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
