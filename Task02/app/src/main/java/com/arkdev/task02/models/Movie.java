package com.arkdev.task02.models;

import android.media.Image;

public class Movie {
    int imgID;
    private String title, genre, year;
    private Image img;

    public Movie(String title, String genre, String year, Image img) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.img = img;
    }

    public Movie(String title, String genre, String year, int imgID) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.imgID = imgID;
    }

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public Image getImg() {
        return img;
    }

    public int getImgID() {
        return imgID;
    }
}
