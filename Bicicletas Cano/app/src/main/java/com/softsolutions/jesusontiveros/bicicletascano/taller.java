package com.softsolutions.jesusontiveros.bicicletascano;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

public class taller extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] imagenes = {};

    String[] titulo = {};
    String[] ids = {};

    String[] desc = {};

    ListView lView;
    String idu;

    ListAdapter lAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        idu=getIntent().getStringExtra("id");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String  url = "http://wcf.softcame.net/tallerList.php?user="+idu;
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                        try {

                            titulo = new String[response.length()];
                            desc = new String[response.length()];
                            imagenes = new String[response.length()];
                            ids = new String[response.length()];
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse;
                                jresponse = response.getJSONObject(i);

                                ids[i] = jresponse.getString("folio");
                                titulo[i] = jresponse.getString("descripcion");
                                imagenes[i] = jresponse.getString("image");
                                desc[i] = jresponse.getString("Marca") +" - " +jresponse.getString("Modelo")  +" - " +jresponse.getString("noserie");

                            }
                            lView = (ListView)findViewById(R.id.androidList);

                            lAdapter = new ListAdapter(taller.this, titulo, desc, imagenes);

                            lView.setAdapter(lAdapter);

                            lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                                    Intent ii = new Intent(taller.this,detalle.class);
                                    ii.putExtra("id",idu);
                                    startActivity(ii);

                                }
                            });





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



    }
    public  void getList(){
        if (isOnlineNet()==true) {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            String url = "http://wcf.softcame.net/tallerList.php?user=" + idu;
            JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // display response
                            try {

                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jresponse;
                                    jresponse = response.getJSONObject(i);

                                    titulo[i] = jresponse.getString("descripcion");
                                    desc[i] = jresponse.getString("Marca") + " - " + jresponse.getString("Modelo") + " - " + jresponse.getString("noserie");

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
        }else {
            Toast.makeText(taller.this, "No se dispone de una conexion a internet.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.taller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            cerrarSesion();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.bicicletas) {
            Intent i = new Intent(this,Inicio.class);
            i.putExtra("id", idu);
            startActivity(i);
            finish();
            // Handle the camera action
        } else if (id == R.id.taller) {


        } else if (id == R.id.autorizacion) {
            Intent i = new Intent(this,autorizaciones.class);
            i.putExtra("id", idu);
            startActivity(i);
            finish();
        }
        else if (id == R.id.cerrarsesion) {
            cerrarSesion();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private  void cerrarSesion(){
        Intent i = new Intent(this,login.class);
        startActivity(i);
        finish();
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
