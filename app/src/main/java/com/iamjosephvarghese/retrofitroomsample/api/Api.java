package com.iamjosephvarghese.retrofitroomsample.api;

import com.google.gson.JsonObject;
import com.iamjosephvarghese.retrofitroomsample.model.Quote;
import com.iamjosephvarghese.retrofitroomsample.model.QuoteAPIModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "http://188.213.166.77:3000/";

//    @Query(value = "from",encoded = true) String from

    @GET("getquote")
    Call<QuoteAPIModel> getQuote();

}