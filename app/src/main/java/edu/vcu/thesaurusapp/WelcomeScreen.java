package edu.vcu.thesaurusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.Bentervalues) {
            Intent i = new Intent(WelcomeScreen.this, EnterValues.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.Bsubmit) {
            Intent i = new Intent(WelcomeScreen.this, Results.class);
            startActivity(i);
        }
    }
}
