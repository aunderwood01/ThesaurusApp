package edu.vcu.thesaurusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by agugo on 3/3/2018.
 */

public class EnterValues extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.Bsubmit) {
            Intent i = new Intent(EnterValues.this, WelcomeScreen.class);
            startActivity(i);
        }
    }
}
