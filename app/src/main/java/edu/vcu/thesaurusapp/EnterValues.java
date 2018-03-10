package edu.vcu.thesaurusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class EnterValues extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.Bsubmit) {
            EditText word = findViewById(R.id.TFWord);
            EditText synonym = findViewById(R.id.TFSynonym);
            String wordStr = word.getText().toString();
            String synonymStr = synonym.getText().toString();

            WordPairs wp = new WordPairs();
            wp.setWord(wordStr);
            wp.setSynonym(synonymStr);
            helper.insertWordPair(wp);

            Intent i = new Intent(EnterValues.this, WelcomeScreen.class);
            startActivity(i);
        }
    }
}
