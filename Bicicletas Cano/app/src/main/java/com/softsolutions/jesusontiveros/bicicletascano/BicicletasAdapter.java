package com.softsolutions.jesusontiveros.bicicletascano;

/**
 * Created by jesus on 3/21/2018.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class BicicletasAdapter extends RecyclerView.Adapter<BicicletasAdapter.MyViewHolder> {

    private Context mContext;
    private List<ObjBicicletas> bicicletasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView marca, modelo;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            marca = (TextView) view.findViewById(R.id.title);
            modelo = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public BicicletasAdapter(Context mContext, List<ObjBicicletas> bicicletasList) {
        this.mContext = mContext;
        this.bicicletasList = bicicletasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bicicleta_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ObjBicicletas bicicleta = bicicletasList.get(position);
        holder.marca.setText(bicicleta.getMarca());
        holder.modelo.setText(bicicleta.getModelo());

        // loading album cover using Glide library
        byte[] imageBytes = Base64.decode(bicicleta.getThumbnail(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        Glide.with(mContext).load(imageBytes).into(holder.thumbnail);


        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
       // PopupMenu popup = new PopupMenu(mContext, view);
       // MenuInflater inflater = popup.getMenuInflater();
       // inflater.inflate(R.menu.activity_inicio_drawer, popup.getMenu());
        //popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
       // popup.show();
    }

    /**
     * Click listener for popup menu items
     */

    @Override
    public int getItemCount() {
        return bicicletasList.size();
    }
}