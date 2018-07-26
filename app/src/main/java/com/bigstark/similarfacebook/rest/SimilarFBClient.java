package com.bigstark.similarfacebook.rest;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SimilarFBClient {

    public static final String BASE_URL = "https://picsum.photos";

    private static SimilarFBClient instance;

    public static SimilarFBClient getInstance() {
        if (instance == null) {
            instance = new SimilarFBClient();
        }

        return instance;
    }

    public static <T> T create(Class<? extends T> type) {
        return getInstance().createInternal(type);
    }


    private HashMap<Class, Object> serviceHashmap = new HashMap<>();
    private Retrofit retrofit;

    SimilarFBClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    <T> T createInternal(Class<T> type) {
        if (serviceHashmap.containsKey(type)) {
            return (T) serviceHashmap.get(type);
        }

        T service = retrofit.create(type);
        serviceHashmap.put(type, service);
        return service;
    }
}
