package com.bigstark.similarfacebook.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class PictureModel {

    private int id;

    private int width;

    private int height;

    private String filename;

    private String format;

    private String author;

    @SerializedName("author_url")
    private String authorUrl;

    @SerializedName("post_url")
    private String postUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureModel that = (PictureModel) o;
        return id == that.id &&
                width == that.width &&
                height == that.height &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(format, that.format) &&
                Objects.equals(author, that.author) &&
                Objects.equals(authorUrl, that.authorUrl) &&
                Objects.equals(postUrl, that.postUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height, filename, format, author, authorUrl, postUrl);
    }

    @Override
    public String toString() {
        return "PictureModel{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", filename='" + filename + '\'' +
                ", format='" + format + '\'' +
                ", author='" + author + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", postUrl='" + postUrl + '\'' +
                '}';
    }
}
