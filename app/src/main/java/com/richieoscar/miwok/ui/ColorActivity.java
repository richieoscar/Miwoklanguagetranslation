package com.richieoscar.miwok.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.adapter.WordAdapter;
import com.richieoscar.miwok.audio.WordAudioManager;
import com.richieoscar.miwok.data.Datamanager;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        setUpRecyclerView(Datamanager.getColors());
    }

    private void setUpRecyclerView(ArrayList<Word> words) {
        RecyclerView recyclerView = findViewById(R.id.color_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        DividerItemDecoration decoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        int color = ContextCompat.getColor(this, R.color.color_color);
        adapter = new WordAdapter(words, color);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        WordAudioManager.releaseMediaPlayer();
    }
}