package com.richieoscar.miwok.model;

public class Word {
    private String englishWord;
    private String mowikTranslation;
    private int image;

    public Word(String mowikTranslation,  String englishWord, int image) {
        this.englishWord = englishWord;
        this.mowikTranslation = mowikTranslation;
        this.image = image;
    }

    public Word(String englishWord, String mowikTranslation) {
        this.englishWord = englishWord;
        this.mowikTranslation = mowikTranslation;
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
}
