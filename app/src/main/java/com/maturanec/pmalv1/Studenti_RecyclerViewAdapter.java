package com.maturanec.pmalv1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class Studenti_RecyclerViewAdapter extends RecyclerView.Adapter<Studenti_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Student> lStudenti;

    public Studenti_RecyclerViewAdapter(Context context, ArrayList<Student> lStudenti) {
        this.context = context;
        this.lStudenti = lStudenti;
    }

    @NonNull
    @Override
    public Studenti_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recylcer_view_row, parent, false);
        return new Studenti_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Studenti_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvIme.setText(lStudenti.get(position).getIme());
        holder.tvPrezime.setText(lStudenti.get(position).getPrezime());
        holder.tvDatumRodenja.setText(lStudenti.get(position).getDatumRodenja());
        holder.tvPredmet.setText(lStudenti.get(position).getPredmet());
        holder.tvProfesor.setText(lStudenti.get(position).getProfesor());
        holder.tvSatiPr.setText(lStudenti.get(position).getSatiPr());
        holder.tvSatiLv.setText(lStudenti.get(position).getSatiLV());
        holder.tvVrsta.setText(lStudenti.get(position).getVrsta());


        Bitmap bitmap = BitmapFactory.decodeFile(lStudenti.get(position).getPicture());
        holder.tvRowImg.setImageBitmap(bitmap);

        /*
        File imageFile = new File(lStudenti.get(position).getPicture());
        if (imageFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            ImageView imageView=(ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(myBitmap);

        }


         */
    }

    @Override
    public int getItemCount() {
        return lStudenti.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the views from our recycler_view_row layout file
        //kinda like in the onCreate method
        TextView tvIme, tvPrezime, tvDatumRodenja, tvPredmet, tvProfesor, tvSatiPr, tvSatiLv, tvVrsta;
        ImageView tvRowImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIme = itemView.findViewById(R.id.textView11);
            tvPrezime = itemView.findViewById(R.id.textView12);
            tvDatumRodenja = itemView.findViewById(R.id.textView13);
            tvPredmet = itemView.findViewById(R.id.textView15);
            tvProfesor = itemView.findViewById(R.id.textView16);
            tvSatiPr = itemView.findViewById(R.id.textView18);
            tvSatiLv = itemView.findViewById(R.id.textView17);
            tvVrsta = itemView.findViewById(R.id.textView19);
            tvRowImg = itemView.findViewById(R.id.rowImg);
        }

    }
}
