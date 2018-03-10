package edu.vcu.thesaurusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WelcomeScreen extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

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
        else if(v.getId() == R.id.Bfindsynonym) {
            EditText userWord = findViewById(R.id.UserWord);
            String userWordStr = userWord.getText().toString();

            String synonym = helper.searchWord(userWordStr);

            Intent i = new Intent(WelcomeScreen.this, Results.class);
            i.putExtra("userWord", userWordStr);
            i.putExtra("synonym", synonym);
            startActivity(i);
        }
    }
}
