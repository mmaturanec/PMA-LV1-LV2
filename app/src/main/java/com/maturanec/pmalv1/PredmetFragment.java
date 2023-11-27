package com.maturanec.pmalv1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PredmetFragment extends Fragment {

    ArrayList<Predmet> predmeti = new ArrayList<>();

    private SharedViewModel sharedViewModel;
    private EditText editTextProfesor;
    private EditText editTextPredmet;
    private EditText editTextSatiPR;
    private EditText editTextSatiLV;
    private String editTextIzborni;
    private Spinner spinner;
    private String PictureUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ApiManager.getInstance().service().getPredmeti().enqueue(new Callback<ArrayList<Predmet>>() {
            @Override
            public void onResponse(Call<ArrayList<Predmet>> call, @NonNull Response<ArrayList<Predmet>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    predmeti.addAll(response.body());
                }

                ArrayList<String> nazivi = new ArrayList<>();
                for(Predmet p : predmeti)
                {
                    nazivi.add(p.naziv);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,nazivi);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Predmet>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predmet, container, false);


        sharedViewModel.postaviIzborni("redovni");
        /////////////////////////////
        editTextPredmet = view.findViewById(R.id.textPredmet1);
        spinner = view.findViewById(R.id.spinnerPredmeti);
        editTextPredmet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviNazivPredmeta(editable.toString());
            }
        });
        editTextProfesor = view.findViewById(R.id.textProfesor1);
        editTextProfesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviNazivProfesora(editable.toString());
            }
        });
        editTextSatiPR = view.findViewById(R.id.textSatiPR);
        editTextSatiPR.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviNazivSatiPR(editable.toString());
            }
        });
        editTextSatiLV = view.findViewById(R.id.textSatiLV);
        editTextSatiLV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviNazivSatiLV(editable.toString());
            }
        });
        Switch textSwitch = (Switch) view.findViewById(R.id.switch4);
        textSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Your code here when the switch is clicked/changed
                if (isChecked) {
                    Toast.makeText(getActivity().getApplicationContext(), "Test checked", Toast.LENGTH_SHORT ).show();
                    sharedViewModel.postaviIzborni("izborni");
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Test UNchecked", Toast.LENGTH_SHORT ).show();
                    sharedViewModel.postaviIzborni("redovni");
                }
            }
        });
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    sharedViewModel.postaviSpinner(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        return view;
    }
}