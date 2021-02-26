package com.richieoscar.miwok.data;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.model.Word;

import java.util.ArrayList;

public class Datamanager {

    private Datamanager(){}

    public  static ArrayList<Word> getNumbers(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("lutti", "One", R.drawable.number_one));
        dataSource.add(new Word("otiiko", "Two", R.drawable.number_two));
        dataSource.add(new Word("tolookosu", "Three", R.drawable.number_three));
        dataSource.add(new Word("oyyisa", "Four", R.drawable.number_four));
        dataSource.add(new Word("massokka", "Five", R.drawable.number_five));
        dataSource.add(new Word("temmokka", "Six", R.drawable.number_six));
        dataSource.add(new Word("kenakaku", "Seven", R.drawable.number_seven));


        return  dataSource;
    }

    public static ArrayList<Word> getFamilyMembers(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("epe", "Father", R.drawable.family_father));
        dataSource.add(new Word("eta", "Mother", R.drawable.family_mother));
        dataSource.add(new Word("angsi", "Son", R.drawable.family_son));
        dataSource.add(new Word("tune", "Daughter", R.drawable.family_daughter));
        dataSource.add(new Word("taachi", "Older Brother", R.drawable.family_older_brother));
        dataSource.add(new Word("otiiko", "Older Sister", R.drawable.family_older_sister));
        dataSource.add(new Word("chalitti", "Younger Brother", R.drawable.family_younger_brother));
        dataSource.add(new Word("kenakaku", "Younger Sister", R.drawable.family_younger_sister));
        dataSource.add(new Word("otiiko", "Grand Father", R.drawable.family_grandfather));
        dataSource.add(new Word("otiiko", "Mother Father", R.drawable.family_grandmother));

        return  dataSource;
    }

    public static ArrayList<Word> getColors(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("wetetti", "Red", R.drawable.color_red));
        dataSource.add(new Word("a'lymca", "Orange", R.drawable.color_red));
        dataSource.add(new Word("tayayyi", "Light Yellow", R.drawable.color_dusty_yellow));
        dataSource.add(new Word("chokokki", "Green", R.drawable.color_green));
        dataSource.add(new Word("co'ki", "Blue", R.drawable.color_brown));
        dataSource.add(new Word("temmokka", "Mustard Yellow", R.drawable.color_mustard_yellow));
        dataSource.add(new Word("kenakaku", "Gray", R.drawable.color_gray));
        dataSource.add(new Word("otiiko", "Black", R.drawable.color_black));
        dataSource.add(new Word("otiiko", "White", R.drawable.color_white));

        return  dataSource;
    }


    public static ArrayList<Word> getPhrases(){
        ArrayList<Word> dataSource = new ArrayList<>();
        dataSource.add(new Word("minto wuksus", "Where are you going?"));
        dataSource.add(new Word("tinne oyaasee'ne", "What is your Name?"));
        dataSource.add(new Word("oyaaset", "My name is"));
        dataSource.add(new Word("michekses", "How are you doing"));
        dataSource.add(new Word("kuchi achit", "I'm feeling good"));
        dataSource.add(new Word("eenes'aa?", "Are you coming"));
        dataSource.add(new Word("hee'aneem", "Yes i am coming"));

        return  dataSource;
    }
}
