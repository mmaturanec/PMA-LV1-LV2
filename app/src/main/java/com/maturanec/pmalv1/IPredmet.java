package com.maturanec.pmalv1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPredmet {
    @GET("read.php")
    Call<ArrayList<Predmet>> getPredmeti();
}
