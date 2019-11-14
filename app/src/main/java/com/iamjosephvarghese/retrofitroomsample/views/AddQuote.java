package com.iamjosephvarghese.retrofitroomsample.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.iamjosephvarghese.retrofitroomsample.R;
import com.iamjosephvarghese.retrofitroomsample.repository.QuoteRepository;

import java.sql.BatchUpdateException;

public class AddQuote extends AppCompatActivity {

    Button button;
    EditText author, data;

    QuoteRepository quoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        button = findViewById(R.id.button);
        author = findViewById(R.id.authorBox);
        data = findViewById(R.id.dataBox);




    }
}
