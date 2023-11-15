package com.maturanec.pmalv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    }

    @Override
    public int getItemCount() {
        return lStudenti.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the views from our recycler_view_row layout file
        //kinda like in the onCreate method
        TextView tvIme, tvPrezime, tvDatumRodenja, tvPredmet, tvProfesor, tvSatiPr, tvSatiLv, tvVrsta;

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

        }

    }
}
