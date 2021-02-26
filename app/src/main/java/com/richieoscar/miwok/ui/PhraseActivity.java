package com.richieoscar.miwok.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.adapter.WordAdapter;
import com.richieoscar.miwok.data.Datamanager;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        setUpRecyclerView(Datamanager.getPhrases());
    }

    private void setUpRecyclerView(ArrayList<Word> words){
        RecyclerView recyclerView = findViewById(R.id.phrase_recyclerview);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        DividerItemDecoration decoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        int color = ContextCompat.getColor(this, R.color.phrase_color);
        WordAdapter adapter = new WordAdapter(words, color);
        recyclerView.setAdapter(adapter);


    }
}