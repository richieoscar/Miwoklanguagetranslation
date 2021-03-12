package com.richieoscar.miwok.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;

import com.richieoscar.miwok.model.Word;

public final class WordAudioManager {

    private static MediaPlayer mediaPlayer;
    private static AudioManager audioManager;
    private static AudioManager.OnAudioFocusChangeListener listener;

    private WordAudioManager(){}

    private static  MediaPlayer.OnCompletionListener getOnCompletionListener() {
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
    public static void setAudioManager(View v, Word word) {
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

    private static  void initializeMediaPlayer(View v, Word word) {
        // We initialize the media player
        // and setup the onCompletionListener
        mediaPlayer = MediaPlayer.create(v.getContext(), word.getAudio());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(getOnCompletionListener());
    }

    public static void releaseMediaPlayer() {
        // The media player resources is released
        // we release the media l
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            //Abandon the audio focus when the media player is not in use
            audioManager.abandonAudioFocus(listener);
        }


    }


}
