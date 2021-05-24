package com.richieoscar.miwok.adapter;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.audio.WordAudioManager;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.NumberViewHolder> {

    private ArrayList<Word> words;
    int colorRes;

    public WordAdapter(ArrayList<Word> words, int colorRes) {
        this.words = words;
        this.colorRes = colorRes;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(words.get(position));
        holder.constraintLayout.setBackgroundColor(colorRes);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView englishWord, miwokTranslation;
        private ImageView image;
        ImageButton play;
        ConstraintLayout constraintLayout;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            englishWord = itemView.findViewById(R.id.textView_english_list);
            miwokTranslation = itemView.findViewById(R.id.textView_miwok_list);
            image = itemView.findViewById(R.id.image_list);
            constraintLayout = itemView.findViewById(R.id.rootLayout);
            play = itemView.findViewById(R.id.imageButton);
            itemView.setOnClickListener(this);
        }

        void bind(Word word) {
            if (word.hasImage()) {
                englishWord.setText(word.getEnglishWord());
                miwokTranslation.setText(word.getMowikTranslation());
                image.setImageResource(word.getImage());

            } else {
                englishWord.setText(word.getEnglishWord());
                miwokTranslation.setText(word.getMowikTranslation());
                image.setVisibility(View.GONE);
            }
        }


        /*release the media player before it is created
        in case the user does a multiple click input on different items the media player object is released and set to null
        before it is created again
         */
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Word word = words.get(position);
            WordAudioManager.releaseMediaPlayer();
            WordAudioManager.setAudioManager(v, word);
        }
    }


}
