package com.example.ravi.customnvaigationdrawer;

import com.google.gson.JsonArray;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ravi on 28-01-2017.
 */

public interface ApiService
{
    @GET("/json/movies.json")
    public void Myeth(Callback<JsonArray> callback);
}
