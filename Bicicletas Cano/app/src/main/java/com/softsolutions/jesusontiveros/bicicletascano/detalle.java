package com.softsolutions.jesusontiveros.bicicletascano;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class detalle extends AppCompatActivity {
    String[] images = {};

    String[] titulo = {};

    String[] desc = {};
    String[] ids = {};

    ListView lView;
    String idu,idm;

    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        idu=getIntent().getStringExtra("id");
        getAutorizaciones();
    }
    private  void  getAutorizaciones(){
        if (isOnlineNet()==true) {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            String url = "http://wcf.softcame.net/detalleList.php?user=" + idu;
            JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // display response
                            try {

                                titulo = new String[response.length()];
                                ids = new String[response.length()];
                                desc = new String[response.length()];
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jresponse;
                                    jresponse = response.getJSONObject(i);

                                    titulo[i] = "Bitacora";
                                    desc[i] = jresponse.getString("estado");
                                    ids[i] = jresponse.getString("id");

                                }
                                lView = (ListView) findViewById(R.id.androidList);

                                lAdapter = new ListAdapter(detalle.this, titulo, desc, images);

                                lView.setAdapter(lAdapter);




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
        }else {
            Toast.makeText(detalle.this, "No se dispone de una conexion a internet.", Toast.LENGTH_SHORT).show();
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
