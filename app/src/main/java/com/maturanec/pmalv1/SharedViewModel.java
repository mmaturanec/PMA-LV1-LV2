package com.maturanec.pmalv1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    //fragment student
    private MutableLiveData<String> podatak = new MutableLiveData<>();
    private MutableLiveData<String> prezime = new MutableLiveData<>();
    private MutableLiveData<String> datumRodenja = new MutableLiveData<>();
    //fragment predmet
    private MutableLiveData<String> nazivPredmeta = new MutableLiveData<>();
    private MutableLiveData<String> nazivProfesora = new MutableLiveData<>();
    private MutableLiveData<String> satiLV = new MutableLiveData<>();
    private MutableLiveData<String> satiPR = new MutableLiveData<>();
    private MutableLiveData<String> izborni = new MutableLiveData<>();


    //fragment student

    public void postaviPodatak(String noviPodatak) {
        podatak.setValue(noviPodatak);
    }
    public void postaviPrezime(String noviPodatak) {
        prezime.setValue(noviPodatak);
    }
    public void postaviDatumRodenja(String noviPodatak) {
        datumRodenja.setValue(noviPodatak);
    }
    //fragment predmet
    public void postaviNazivPredmeta(String noviPodatak) {nazivPredmeta.setValue(noviPodatak);}
    public void postaviNazivProfesora(String noviPodatak) {nazivProfesora.setValue(noviPodatak);}
    public void postaviNazivSatiLV(String noviPodatak) {satiLV.setValue(noviPodatak);}
    public void postaviNazivSatiPR(String noviPodatak) {satiPR.setValue(noviPodatak);}
    public void postaviIzborni(String noviPodatak) {izborni.setValue(noviPodatak);}
//fragment student
    public LiveData<String> dohvatiPodatak() {
        return podatak;
    }
    public LiveData<String> dohvatiPrezime() {
        return prezime;
    }
    public LiveData<String> dohvatiDatumRodenja() {
        return datumRodenja;
    }
  //fragment predmet
    public LiveData<String> dohvatiNazivPredmeta() {
        return nazivPredmeta;
    }
    public LiveData<String> dohvatiNazivProfesora() {
        return nazivProfesora;
    }
    public LiveData<String> dohvatiSatiPR() {
        return satiPR;
    }
    public LiveData<String> dohvatiSatiLV() {
        return satiLV;
    }
    public LiveData<String> dohvatiIzborni() {
        return izborni;
    }
}

