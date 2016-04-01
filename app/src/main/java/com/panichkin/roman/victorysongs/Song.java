package com.panichkin.roman.victorysongs;

import java.io.Serializable;

/**
 * Created by Wu on 27.03.2016.
 */
public class Song implements Serializable{
    String name;
    String lyrics;
    double sourceId;

    public Song (String name, String lyrics, double sourceId){
        this.name = name;
        this.lyrics = lyrics;
        this.sourceId = sourceId;
    }

    public String getLyrics(){
        return lyrics;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
