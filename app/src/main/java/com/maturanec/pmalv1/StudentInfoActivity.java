package com.maturanec.pmalv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {
    private Switch oKons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

            Button btnSIA = findViewById(R.id.btnSIA);
        TextInputEditText textPredmet = findViewById(R.id.textPredmet1);
        TextInputEditText textProfesor = findViewById(R.id.textProfesor);
        TextInputEditText textSatiLV = findViewById(R.id.textSatiLV);
        TextInputEditText textSatiPR = findViewById(R.id.textSatiPR);
        Switch textSwitch = (Switch) findViewById(R.id.switch1);


        btnSIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPredmet = textPredmet.getText().toString();
                String sProfesor = textProfesor.getText().toString();
                String sSatiLV = textSatiLV.getText().toString();
                String sSatiPR  = textSatiPR.getText().toString();

                final Bundle oExtras = getIntent().getExtras();
                String sPreuzetoIme = oExtras.getString("ime");
                String sPreuzetoPrezime = oExtras.getString("prezime");
                String sPreuzetoDatum = oExtras.getString("datum");
                Switch textSwitch = (Switch) findViewById(R.id.switch1);
                String switchtext = "";
                if(textSwitch.isChecked())
                {
                    switchtext  = "izborni";

                }
                else{
                     switchtext = "redovni";

                }
                if(TextUtils.isEmpty(sPredmet) || TextUtils.isEmpty(sProfesor) || TextUtils.isEmpty(sSatiLV) || TextUtils.isEmpty(sPredmet) ||TextUtils.isEmpty(sSatiPR))
                {
                    Toast.makeText(StudentInfoActivity.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent otvoriSummary = new Intent(getApplicationContext(), SummaryActivity.class);
                    otvoriSummary.putExtra("ime", sPreuzetoIme);
                    otvoriSummary.putExtra("prezime", sPreuzetoPrezime);
                    otvoriSummary.putExtra("datum", sPreuzetoDatum);
                    otvoriSummary.putExtra("predmet", sPredmet);
                    otvoriSummary.putExtra("profesor", sProfesor);
                    otvoriSummary.putExtra("satilv", sSatiLV);
                    otvoriSummary.putExtra("satipr", sSatiPR);
                    otvoriSummary.putExtra("switch", switchtext);

                    startActivity(otvoriSummary);
                }
            }
        });
    }
}