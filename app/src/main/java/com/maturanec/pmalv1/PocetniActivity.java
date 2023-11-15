package com.maturanec.pmalv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PocetniActivity extends AppCompatActivity {

    Button btnJedan;
    Spinner spinner;
    Locale locale;
    String currentLanguage = "en", currentLang;

    ArrayList<Student> lStudenti =new ArrayList<Student>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni);
        lStudenti = (ArrayList<Student>) StudentSingleton.getInstance().getStudenti();

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        Studenti_RecyclerViewAdapter adapterRV = new Studenti_RecyclerViewAdapter(this, lStudenti);
        recyclerView.setAdapter(adapterRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        btnJedan = findViewById(R.id.btnOne);
        currentLanguage = getIntent().getStringExtra(currentLang);
        spinner = findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add("Select Language");
        list.add("English");
        list.add("Croatian");
        list.add("German");

        btnJedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otvoriStudentInfo = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(otvoriStudentInfo);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        setLocale("en");
                        break;
                    case 2:
                        setLocale("hr");
                        break;
                    case 3:
                        setLocale("de");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            locale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this,
                    PocetniActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(PocetniActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }

}