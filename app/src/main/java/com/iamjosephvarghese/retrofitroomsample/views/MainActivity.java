package com.iamjosephvarghese.retrofitroomsample.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamjosephvarghese.retrofitroomsample.R;
import com.iamjosephvarghese.retrofitroomsample.model.Quote;
import com.iamjosephvarghese.retrofitroomsample.repository.QuoteRepository;

public class MainActivity extends AppCompatActivity {


    Button addButton, getButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        getButton = findViewById(R.id.getButton);
        editText = findViewById(R.id.editText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this,AddQuote.class);
                startActivity(addIntent);
            }
        });


        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString() != null){
                    Intent getIntent = new Intent(MainActivity.this,ViewQuote.class);
                    getIntent.putExtra("author",editText.getText().toString());
                    startActivity(getIntent);
                }

            }
        });






    }
}
