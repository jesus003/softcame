package com.softsolutions.jesusontiveros.bicicletascano;

import android.content.Intent;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {


    private String url = "http://wcf.softcame.net/login.php?";
    EditText txtUsuario,txtPass;

    ObjUsuario objUsuario = new ObjUsuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        txtPass=(EditText)findViewById(R.id.txtPass);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);

    }

    public  void validLogin(View v){
        if(!txtUsuario.getText().toString().equals("") && !txtUsuario.getText().toString().equals("")){
            RequestQueue queue = Volley.newRequestQueue(this);

            url = url+"user="+txtUsuario.getText().toString()+"&pass="+txtPass.getText().toString();
            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
                            try {
                                JSONArray valid = response.getJSONArray("login");
                                JSONObject obj = valid.getJSONObject(0);
                                if(Integer.parseInt(obj.getString("id_cliente"))>0){
                                    SaveDataLogin preferencias = new SaveDataLogin(login.this);
                                    preferencias.guardaPreferencias(obj.getString("nombre"),obj.getString("id_cliente"));
                                    Intent i = new Intent(login.this,Inicio.class);
                                    startActivity(i);
                                    finish();
                                }else {
                                    Toast.makeText(login.this,"Usuario o Contraseña erroneos",Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.getMessage());
                        }
                    }
            );
            queue.add(getRequest);
        }else {
            Toast.makeText(login.this,"Debe ingresar todos los datos.",Toast.LENGTH_SHORT).show();
        }

    }
}
