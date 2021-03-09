package com.richieoscar.miwok.data;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class Datamanager {

    private Datamanager(){}

    public  static ArrayList<Word> getNumbers(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("lutti", "One", R.drawable.number_one, R.raw.number_one));
        dataSource.add(new Word("otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        dataSource.add(new Word("tolookosu", "Three", R.drawable.number_three, R.raw.number_three));
        dataSource.add(new Word("oyyisa", "Four", R.drawable.number_four,R.raw.number_four));
        dataSource.add(new Word("massokka", "Five", R.drawable.number_five, R.raw.number_five));
        dataSource.add(new Word("temmokka", "Six", R.drawable.number_six, R.raw.number_six));
        dataSource.add(new Word("kenakaku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        dataSource.add(new Word("kawinta", "Eight", R.drawable.number_eight, R.raw.number_eight));
        dataSource.add(new Word("woeh", "Nine", R.drawable.number_nine, R.raw.number_nine));
        dataSource.add(new Word("naachaa", "Ten", R.drawable.number_ten, R.raw.number_ten));
        return  dataSource;
    }

    public static ArrayList<Word> getFamilyMembers(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("epe", "Father", R.drawable.family_father, R.raw.family_father));
        dataSource.add(new Word("eta", "Mother", R.drawable.family_mother, R.raw.family_mother));
        dataSource.add(new Word("angsi", "Son", R.drawable.family_son, R.raw.family_son));
        dataSource.add(new Word("tune", "Daughter", R.drawable.family_daughter, R.raw.family_daughter));
        dataSource.add(new Word("taachi", "Older Brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        dataSource.add(new Word("teetee", "Older Sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        dataSource.add(new Word("chalitti", "Younger Brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        dataSource.add(new Word("kolitti", "Younger Sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        dataSource.add(new Word("papa", "Grand Father", R.drawable.family_grandfather, R.raw.family_grandfather));
        dataSource.add(new Word("amma", "Grand Mother", R.drawable.family_grandmother, R.raw.family_grandmother));
        return  dataSource;
    }

    public static ArrayList<Word> getColors(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("wetetti", "Red", R.drawable.color_red, R.raw.color_red));
        dataSource.add(new Word("topissu", "Light Yellow", R.drawable.color_dusty_yellow,  R.raw.color_dusty_yellow));
        dataSource.add(new Word("chokokki", "Green", R.drawable.color_green,  R.raw.color_green));
        dataSource.add(new Word("takaaki", "Brown", R.drawable.color_brown,  R.raw.color_brown));
        dataSource.add(new Word("cheeweedoo", "Mustard Yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        dataSource.add(new Word("topopi", "Gray", R.drawable.color_gray,  R.raw.color_gray));
        dataSource.add(new Word("kolooli", "Black", R.drawable.color_black,  R.raw.color_black));
        dataSource.add(new Word("kaleli", "White", R.drawable.color_white,  R.raw.color_white));
        return  dataSource;
    }


    public static ArrayList<Word> getPhrases(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("minto wuksus", R.raw.phrase_where_are_you_going, "Where are you going?"));
        dataSource.add(new Word("tinne oyaasee'ne",R.raw.phrase_what_is_your_name, "What is your Name?"));
        dataSource.add(new Word("oyaaset",R.raw.phrase_my_name_is, "My name is"));
        dataSource.add(new Word("michekses",R.raw.phrase_how_are_you_feeling, "How are you doing"));
        dataSource.add(new Word("kuchi achit", R.raw.phrase_im_feeling_good, "I'm feeling good"));
        dataSource.add(new Word("eenes'aa?",R.raw.phrase_are_you_coming, "Are you coming"));
        dataSource.add(new Word("hee'aneem", R.raw.phrase_yes_im_coming,"Yes i am coming"));
        return  dataSource;
    }
}
