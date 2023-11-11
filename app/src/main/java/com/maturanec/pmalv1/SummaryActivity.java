package com.maturanec.pmalv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();
        String sIme = oExtras.getString("ime");
        String sPrezime = oExtras.getString("prezime");
        String sDatum = oExtras.getString("datum");
        String sProfesor = oExtras.getString("profesor");
        String sSatiPR = oExtras.getString("satipr");
        String sSatiLV = oExtras.getString("satilv");
        String sVrsta = oExtras.getString("switch");
        String sPredmet = oExtras.getString("predmet");
        TextView imeView = (TextView) findViewById(R.id.viewIme);
        TextView predmetView = (TextView) findViewById(R.id.viewPredmet);
        TextView prezimeView = (TextView) findViewById(R.id.viewPrezime);
        TextView datumView = (TextView) findViewById(R.id.viewDatum);
        TextView profesorView = (TextView) findViewById(R.id.viewProfesor);
        TextView satiprView = (TextView) findViewById(R.id.viewSatiPR);
        TextView satilvView = (TextView) findViewById(R.id.viewSatiLV);
        TextView vrstaView = (TextView) findViewById(R.id.viewVrstaPredmeta);


        imeView.setText(sIme);
        prezimeView.setText(sPrezime);
        datumView.setText(sDatum);
        profesorView.setText(sProfesor);
        satiprView.setText(sSatiPR);
        satilvView.setText(sSatiLV);
        vrstaView.setText(sVrsta);
        predmetView.setText(sPredmet);

        Button btnPocetna = findViewById(R.id.btnPocetna);

        btnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPocetna = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(intPocetna);
            }
        });
    }
}