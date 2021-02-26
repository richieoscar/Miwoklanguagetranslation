package com.richieoscar.miwok.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.richieoscar.miwok.R;

public class MainActivity extends AppCompatActivity {

    TextView numbers, familyMembers, colors, phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = findViewById(R.id.textView_numbers);
        familyMembers = findViewById(R.id.textView_familiy);
        colors = findViewById(R.id.textViw_colors);
        phrases = findViewById(R.id.textView_phrases);


        openNumberTranslation();
        openFamilyMembersTranslation();
        openColorTranslation();
        openPhraseTranslation();
    }

    private void openNumberTranslation(){
        numbers.setOnClickListener(v->{
        startActivity(new Intent(this, NumberActivity.class));

        });
    }

    private void openFamilyMembersTranslation(){
        familyMembers.setOnClickListener(v->{
            startActivity(new Intent(this, FamilyActivity.class));

        });
    }

    private void openColorTranslation(){
        colors.setOnClickListener(v->{
            startActivity(new Intent(this, ColorActivity.class));

        });
    }
    private void openPhraseTranslation(){
        phrases.setOnClickListener(v->{
            startActivity(new Intent(this, PhraseActivity.class));

        });
    }



}