package com.maturanec.pmalv1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static ApiManager instance;
    private IPredmet service;
    private ApiManager(){
        Retrofit.Builder builder = new Retrofit.Builder();
//postavljanje retrofit-a
        Retrofit retrofit = builder.baseUrl("http://31.147.206.25/racunarstvo_android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(IPredmet.class);
    }
    public static ApiManager getInstance(){
        if (instance == null){
            instance = new ApiManager();
        }
        return instance;
    }
    public IPredmet service(){
        return service;
    }
}
