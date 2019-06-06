package com.example.catfacts;


public class Fact  {
    private String id;
    private String text;
    private String imageURL;
    private  Boolean isFavorite;




    public Fact() {
        this.id = "id";
        this.text = "text";
        this.imageURL = "imageURL";
        this.isFavorite = false;
    }
    public Fact(String id, String text, String imageURL) {
        this.id = id;
        this.text = text;
        this.imageURL = imageURL;
        this.isFavorite = false;
    }
    public Fact(String id, String text, String imageURL, Boolean isFavorite) {
        this.id = id;
        this.text = text;
        this.imageURL = imageURL;
        this.isFavorite = false;
    }


//getters
    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }
    //setters


    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}

