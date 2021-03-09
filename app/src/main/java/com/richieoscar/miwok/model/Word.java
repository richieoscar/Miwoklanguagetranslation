package com.richieoscar.miwok.model;

public class Word {
    private String englishWord;
    private String mowikTranslation;
    private int image = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private int audio;

    public int getAudio() {
        return audio;
    }

    public Word(String englishWord, String mowikTranslation, int image, int audio) {
        this.englishWord = englishWord;
        this.mowikTranslation = mowikTranslation;
        this.image = image;
        this.audio = audio;
    }

    public Word(String mowikTranslation, String englishWord, int image) {
        this.englishWord = englishWord;
        this.mowikTranslation = mowikTranslation;
        this.image = image;
    }


    public Word(String englishWord, int audio, String mowikTranslation) {
        this.englishWord = englishWord;
        this.mowikTranslation = mowikTranslation;
        this.audio = audio;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getMowikTranslation() {
        return mowikTranslation;
    }

    public int getImage() {
        return image;
    }

    public boolean hasImage(){
       return image!= NO_IMAGE;
    }
}
