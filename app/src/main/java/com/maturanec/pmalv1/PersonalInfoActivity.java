package com.maturanec.pmalv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPIA = findViewById(R.id.btnPIA);
        TextInputEditText txtIme = findViewById(R.id.textIme);
        TextInputEditText txtPrezime = findViewById(R.id.textPrezime);
        TextInputEditText txtDatum = findViewById(R.id.textDatum);


        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Odaberite datum").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();


        txtDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            datePicker.show(getSupportFragmentManager(), "Material_Date_Picker");
            datePicker.addOnPositiveButtonClickListener(selection -> txtDatum.setText(datePicker.getHeaderText()));
            }
        });
        btnPIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sIme = txtIme.getText().toString();
                String sPrezime = txtPrezime.getText().toString();
                String sDatum = txtDatum.getText().toString();
                if(TextUtils.isEmpty(sIme) || TextUtils.isEmpty(sPrezime) || TextUtils.isEmpty(sDatum))
                {
                    Toast.makeText(PersonalInfoActivity.this, "Unesite sva polja!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent otvoriStudentInfoActivity = new Intent(getApplicationContext(), StudentInfoActivity.class);
                    otvoriStudentInfoActivity.putExtra("ime", sIme);
                    otvoriStudentInfoActivity.putExtra("prezime", sPrezime);
                    otvoriStudentInfoActivity.putExtra("datum", sDatum);

                    startActivity(otvoriStudentInfoActivity);
                }


            }
        });

    }

}