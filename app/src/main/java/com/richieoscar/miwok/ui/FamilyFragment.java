package com.richieoscar.miwok.ui;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.adapter.WordAdapter;
import com.richieoscar.miwok.audio.WordAudioManager;
import com.richieoscar.miwok.data.Datamanager;
import com.richieoscar.miwok.databinding.FragmentFamilyBinding;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;


public class FamilyFragment extends Fragment {
        private FragmentFamilyBinding binding;
        private WordAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_family, container, false);
        setUpRecyclerView(Datamanager.getFamilyMembers());
        playAll();
        return binding.getRoot();
    }
    private void setUpRecyclerView(ArrayList<Word> words) {
        RecyclerView recyclerView = binding.familyRecylerview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        int color = ContextCompat.getColor(getContext(), R.color.family_color);
        adapter = new WordAdapter(words, color);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        WordAudioManager.releaseMediaPlayer();
    }

    public void playAll() {
        binding.playAll.setOnClickListener(v ->{
            WordAudioManager.reset();
            play();
        });
    }

    private void play() {
        ArrayList<Word> numbers = Datamanager.getFamilyMembers();
        int count = WordAudioManager.getIndex();
        WordAudioManager.play(getContext(), numbers, count);

    }
}