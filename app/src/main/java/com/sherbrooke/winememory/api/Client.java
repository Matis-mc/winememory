package com.sherbrooke.winememory.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Client instance = null;
    private Api api;

    /**
     * Création du client retrofit
     */
    private Client(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    /**
     * Récupère une instance du client retrofit.
     * @return
     */
    public static synchronized Client getInstance() {
        if(instance == null){
            instance = new Client();
        }
        return instance;
    }

    public Api getApi(){
        return api;
    }
}
