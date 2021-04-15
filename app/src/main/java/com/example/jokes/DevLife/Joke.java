package com.example.jokes.DevLife;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("gifURL")
    @Expose
    private String gifURL;
    @SerializedName("gifSize")
    @Expose
    private Integer gifSize;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;
    @SerializedName("videoURL")
    @Expose
    private String videoURL;
    @SerializedName("videoPath")
    @Expose
    private String videoPath;
    @SerializedName("videoSize")
    @Expose
    private Integer videoSize;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("commentsCount")
    @Expose
    private Integer commentsCount;
    @SerializedName("fileSize")
    @Expose
    private Integer fileSize;
    @SerializedName("canVote")
    @Expose
    private Boolean canVote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGifURL() {
        return gifURL;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }

    public Integer getGifSize() {
        return gifSize;
    }

    public void setGifSize(Integer gifSize) {
        this.gifSize = gifSize;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Integer getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(Integer videoSize) {
        this.videoSize = videoSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getCanVote() {
        return canVote;
    }

    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }
}
