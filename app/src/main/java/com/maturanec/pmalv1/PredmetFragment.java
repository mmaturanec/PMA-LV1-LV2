package com.maturanec.pmalv1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;


public class PredmetFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private EditText editTextProfesor;
    private EditText editTextPredmet;
    private EditText editTextSatiPR;
    private EditText editTextSatiLV;
    private String editTextIzborni;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predmet, container, false);
        /////////////////////////////
        editTextPredmet = view.findViewById(R.id.textPredmet1);
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
        String switchtext = "";
        if(textSwitch.isChecked())
        {
            sharedViewModel.postaviIzborni("izborni");
        }
        else{
            sharedViewModel.postaviIzborni("redovni");
        }
        return view;
    }
}