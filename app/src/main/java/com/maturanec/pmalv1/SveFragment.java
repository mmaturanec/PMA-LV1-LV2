package com.maturanec.pmalv1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SveFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private TextView tvImeStudenta;
    private TextView tvPrezimeStudenta;
    private TextView tvDatumRodenjaStudenta;
    private TextView tvPredmet;
    private TextView tvProfesor;
    private TextView tvSatiPR;
    private TextView tvSatiLV;
    private TextView tvIzborni;
    private TextView tvRowImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sve, container, false);
        Button btnPocetna = view.findViewById(R.id.btnPocetna);

        tvImeStudenta = view.findViewById(R.id.viewIme);
        tvPrezimeStudenta = view.findViewById(R.id.viewPrezime);
        tvDatumRodenjaStudenta = view.findViewById(R.id.viewDatum);
        tvPredmet = view.findViewById(R.id.viewPredmet);
        tvProfesor = view.findViewById(R.id.viewProfesor);
        tvSatiLV = view.findViewById(R.id.viewSatiLV);
        tvSatiPR = view.findViewById(R.id.viewSatiPR);
        tvIzborni = view.findViewById(R.id.viewVrstaPredmeta);
        tvRowImg = view.findViewById(R.id.pictureView);

        tvRowImg.setText("");
        sharedViewModel.dohvatiPicture().observe(getViewLifecycleOwner(), novoIme -> tvRowImg.setText(novoIme));

        tvImeStudenta.setText("");
        sharedViewModel.dohvatiPodatak().observe(getViewLifecycleOwner(), novoIme -> tvImeStudenta.setText(novoIme));

        tvPrezimeStudenta.setText("");
        sharedViewModel.dohvatiPrezime().observe(getViewLifecycleOwner(), novoIme -> tvPrezimeStudenta.setText(novoIme));

        tvDatumRodenjaStudenta.setText("");
        sharedViewModel.dohvatiDatumRodenja().observe(getViewLifecycleOwner(), novoIme -> tvDatumRodenjaStudenta.setText(novoIme));

        tvProfesor.setText("");
        sharedViewModel.dohvatiNazivProfesora().observe(getViewLifecycleOwner(), novoIme -> tvProfesor.setText(novoIme));
        tvPredmet.setText("");
        sharedViewModel.dohvatiNazivPredmeta().observe(getViewLifecycleOwner(), novoIme -> tvPredmet.setText(novoIme));
        tvSatiPR.setText("");
        sharedViewModel.dohvatiSatiPR().observe(getViewLifecycleOwner(), novoIme -> tvSatiPR.setText(novoIme));
        tvSatiLV.setText("");
        sharedViewModel.dohvatiSatiLV().observe(getViewLifecycleOwner(), novoIme -> tvSatiLV.setText(novoIme));
        tvIzborni.setText("");
        sharedViewModel.dohvatiIzborni().observe(getViewLifecycleOwner(), novoIme -> tvIzborni.setText(novoIme));

        btnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPocetna = new Intent(getActivity(), PocetniActivity.class);

                StudentSingleton.getInstance().addStudent(new Student(tvImeStudenta.getText().toString(), tvPrezimeStudenta.getText().toString(), tvDatumRodenjaStudenta.getText().toString(), tvPredmet.getText().toString(), tvProfesor.getText().toString(), tvSatiPR.getText().toString(), tvSatiLV.getText().toString(), tvIzborni.getText().toString(), tvRowImg.getText().toString()));
                startActivity(intPocetna);
            }
        });
        return view;
    }
}