package com.lbloop.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lbloop.BR;

import java.util.Date;


public class Movie extends BaseObservable {

    private String genre;
    private String imageUrl;
    private Date publicationDate;
    private String title;

    @Bindable
    public int getItemType() {
        return itemType;
    }

    private int itemType;

    public Movie() {

    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public Movie setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
        return this;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public Movie setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    @Bindable
    public Date getPublicationDate() {
        return publicationDate;
    }

    public Movie setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        notifyPropertyChanged(BR.publicationDate);
        return this;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
        return this;
    }

    public Movie setItemType(int itemType)
    {
        this.itemType = itemType;
        notifyPropertyChanged(BR.itemType);
        return this;
    }
}
