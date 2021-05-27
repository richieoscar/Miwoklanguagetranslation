package com.richieoscar.miwok.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public final class WordAudioManager {

    private static MediaPlayer mediaPlayer;
    private static MediaPlayer mediaPlayer2;
    private static AudioManager audioManager;
    private static Timer timer;
    private static int index = 0;
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
    public static void setAudioManager(Context context, Word word) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
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
            initializeMediaPlayer(context, word);
        }
    }

    public static int getIndex() {
        return index;
    }

    private static  void initializeMediaPlayer(Context context, Word word) {
        // We initialize the media player
        // and setup the onCompletionListener
        mediaPlayer = MediaPlayer.create(context, word.getAudio());
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

    public static void play(Context context, ArrayList<Word> words, int pos){
       mediaPlayer2 = MediaPlayer.create(context, words.get(pos).getAudio());
       mediaPlayer2.start();
       timer = new Timer();
       if (words.size()>1) playNext(context, words);
       else mediaPlayer2.reset();
    }

    private static void playNext(Context context, ArrayList<Word> words) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mediaPlayer2!=null){
                mediaPlayer2.reset();
                }
                mediaPlayer2 = MediaPlayer.create(context, words.get(++index).getAudio());
                mediaPlayer2.start();
                if (words.size()> index +1){
                    playNext(context, words);
                }
            }

        }, mediaPlayer2.getDuration()+100);
    }

    public static void reset(){
        index = 0;
    }

    public static void release(){
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            mediaPlayer2 = null;

            //Abandon the audio focus when the media player is not in use
           // audioManager.abandonAudioFocus(listener);
        }
    }


}
