package edu.vcu.thesaurusapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Results extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String userWord = getIntent().getStringExtra("userWord");
        String synonym = getIntent().getStringExtra("synonym");

        TextView tv1 = findViewById(R.id.TVUserWord);
        tv1.setText(userWord);

        TextView tv2 = findViewById(R.id.TVSynonym);
        tv2.setText(synonym);
    }
}
