package com.iamjosephvarghese.retrofitroomsample.views;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.iamjosephvarghese.retrofitroomsample.R;
import com.iamjosephvarghese.retrofitroomsample.model.QuoteAPIModel;
import com.iamjosephvarghese.retrofitroomsample.utils.RetrofitClient;

public class ShowImage extends AppCompatActivity {

    Call<QuoteAPIModel> fetchQuoteCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        fetchQuoteCall = RetrofitClient.getInstance(this).getDataFromServer().getQuote();
        fetchQuoteCall.clone().enqueue(new Callback<QuoteAPIModel>() {
            @Override
            public void onResponse(Call<QuoteAPIModel> call, Response<QuoteAPIModel> response) {
                Log.d("response",response.body().author);
            }

            @Override
            public void onFailure(Call<QuoteAPIModel> call, Throwable t) {

                Log.d("error",t.toString());
            }
        });
    }
}
