package com.maturanec.pmalv1;

public class Student {

    String Ime;
    String Prezime;
    String DatumRodenja;
    String Predmet;
    String Profesor;
    String SatiPr;
    String SatiLV;
    String Vrsta;
    String Picture;

    public Student(String ime, String prezime, String datumRodenja, String predmet, String profesor, String satiPr, String satiLV, String vrsta, String picture) {
        Ime = ime;
        Prezime = prezime;
        DatumRodenja = datumRodenja;
        Predmet = predmet;
        Profesor = profesor;
        SatiPr = satiPr;
        SatiLV = satiLV;
        Vrsta = vrsta;
        Picture = picture;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getDatumRodenja() {
        return DatumRodenja;
    }

    public String getPredmet() {
        return Predmet;
    }

    public String getProfesor() {
        return Profesor;
    }

    public String getSatiPr() {
        return SatiPr;
    }

    public String getSatiLV() {
        return SatiLV;
    }

    public String getVrsta() {
        return Vrsta;
    }

    public String getPicture() {
        return Picture;
    }
}
