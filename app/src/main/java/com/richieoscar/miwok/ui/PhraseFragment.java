package com.richieoscar.miwok.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.adapter.WordAdapter;
import com.richieoscar.miwok.audio.WordAudioManager;
import com.richieoscar.miwok.data.Datamanager;
import com.richieoscar.miwok.databinding.FragmentPhraseBinding;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class PhraseFragment extends Fragment {

    private FragmentPhraseBinding binding;
    private WordAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phrase, container, false);
        setUpRecyclerView(Datamanager.getPhrases());
        return binding.getRoot();
    }

    private void setUpRecyclerView(ArrayList<Word> words) {
        RecyclerView recyclerView = binding.phraseRecyclerview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        int color = ContextCompat.getColor(getContext(), R.color.phrase_color);
        adapter = new WordAdapter(words, color);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        WordAudioManager.releaseMediaPlayer();
    }
}