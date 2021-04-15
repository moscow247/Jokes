package com.example.jokes.DevLife;

public class PreviousPost {
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getGifURL() {
        return gifURL;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }

    private String textDescription;
    private String gifURL;

    public PreviousPost(String textDescription, String gifURL) {
        this.textDescription = textDescription;
        this.gifURL = gifURL;
    }
}
