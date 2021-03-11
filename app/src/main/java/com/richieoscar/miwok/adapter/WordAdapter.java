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
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.NumberViewHolder> {

    private ArrayList<Word> words;
    int colorRes;
    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener listener;


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

    private MediaPlayer.OnCompletionListener getOnCompletionListener() {
        MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        };
        return onCompletionListener;
    }

    /* we initialize the audioManager Focus here
        and also initialize the audioFocusListener
     */
    private void setAudioManager(View v, Word word) {
        audioManager = (AudioManager) v.getContext().getSystemService(Context.AUDIO_SERVICE);
        listener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    // PAUSE THE MUSIC when we temporarily loose audioFocus
                    //And set it to start from beginning
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);//starts from the beginning of song
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    //We start the media player when we gain audio focus
                    mediaPlayer.start();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    //We release media player  resources and abandon the audio focus listener when we
                    // permanently loose focus
                    releaseMediaPlayer();
                }

            }
        };

        // The requestAudioFocus method returns an integer constant from the audio manager class
        // we use the return value to check if it is equal to AUDIO MANAGER REQUEST GRANTED CONSTANT
        int result = audioManager.requestAudioFocus(listener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            //we have audio focus, we can play the file
            initializeMediaPlayer(v, word);

        }

    }

    private void initializeMediaPlayer(View v, Word word) {
        // We initialize the media player
        // and setup the onCompletionListener
        mediaPlayer = MediaPlayer.create(v.getContext(), word.getAudio());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(getOnCompletionListener());
    }

    public void releaseMediaPlayer() {
        // The media player resources is released
        // we release the media l
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            //Abandon the audio focus when the media player is not in use
            audioManager.abandonAudioFocus(listener);
        }

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
            releaseMediaPlayer();
            setAudioManager(v, word);
        }
    }


}
