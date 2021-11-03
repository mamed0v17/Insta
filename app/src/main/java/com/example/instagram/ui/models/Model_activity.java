package com.example.instagram.ui.models;

public class Model_activity {

    private int image, liked_photo;
    private String post;

    public Model_activity(int image, int liked_photo, String post) {
        this.image = image;
        this.liked_photo = liked_photo;
        this.post = post;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLiked_photo() {
        return liked_photo;
    }

    public void setLiked_photo(int liked_photo) {
        this.liked_photo = liked_photo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
