package com.richieoscar.miwok.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.item_about:
                Toast.makeText(this, "About Miwok", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
        return super.onOptionsItemSelected(item);
    }
}