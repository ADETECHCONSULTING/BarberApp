package com.example.adama.haircut.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adama.haircut.R;
import com.example.adama.haircut.modele.Barber;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Adama on 22/01/2018.
 */

public class BarberAdapter extends RecyclerView.Adapter {

    ArrayList<Barber> lesBarbers;
    Context _context;

    public BarberAdapter(Context context){
        this._context = context;
    }

    public void resetData(ArrayList<Barber> lesBarbers){
        this.lesBarbers = lesBarbers;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.barber_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vHolder = (ViewHolder)holder;

        vHolder.lblName.setText(lesBarbers.get(position).getName());
        vHolder.lblDescription.setText(lesBarbers.get(position).getDescription());
        Picasso.with(_context).load(lesBarbers.get(position).getUrlImage()).into(vHolder.roundImage);
    }

    @Override
    public int getItemCount() {
        return lesBarbers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lblName;
        public TextView lblDescription;
        public ImageView roundImage;

        public ViewHolder(View itemView) {
            super(itemView);

            lblName = itemView.findViewById(R.id.lblRoundNameBarber);
            lblDescription = itemView.findViewById(R.id.lblRoundDescription);
            roundImage = itemView.findViewById(R.id.imgRoundBarber);
        }
    }
}
