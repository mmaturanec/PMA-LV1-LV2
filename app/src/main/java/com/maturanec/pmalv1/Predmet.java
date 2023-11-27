package com.maturanec.pmalv1;

public class Predmet {
    String naziv;
    String id;
    String url;
    public Predmet(String naziv, String id, String url) {
        this.naziv = naziv;
        this.id = id;
        this.url = url;
    }
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
