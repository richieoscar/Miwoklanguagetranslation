package com.richieoscar.miwok.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.NumberViewHolder> {

    ArrayList<Word> words;
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

    public class NumberViewHolder extends RecyclerView.ViewHolder {
      private   TextView englishWord, miwokTranslation;
       private ImageView image;
       ConstraintLayout constraintLayout;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            englishWord = itemView.findViewById(R.id.textView_english_list);
            miwokTranslation = itemView.findViewById(R.id.textView_miwok_list);
            image = itemView.findViewById(R.id.image_list);
            constraintLayout = itemView.findViewById(R.id.rootLayout);
        }

        void bind(Word word){
            englishWord.setText(word.getEnglishWord());
            miwokTranslation.setText(word.getMowikTranslation());
            image.setImageResource(word.getImage());

        }
    }
}
