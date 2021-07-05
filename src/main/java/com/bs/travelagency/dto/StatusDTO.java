package com.bs.travelagency.dto;

import java.util.Date;

public class StatusDTO {

    //region for private variables
    private Long postId;
    private String post;
    private String location;
    private int postPrivacy;
    private Date postDate;
    private String userName;
    //endregion

    //region for constructor
    public StatusDTO() {
    }

    public StatusDTO(Long postId, String post, String location, int postPrivacy, Date postDate) {
        this.postId = postId;
        this.post = post;
        this.location = location;
        this.postPrivacy = postPrivacy;
        this.postDate = postDate;
    }

    public StatusDTO(Long postId, String post, String location, int postPrivacy) {
        this.postId = postId;
        this.post = post;
        this.location = location;
        this.postPrivacy = postPrivacy;
    }
    //endregion


    //region for getter setter
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPostPrivacy() {
        return postPrivacy;
    }

    public void setPostPrivacy(int postPrivacy) {
        this.postPrivacy = postPrivacy;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    //endregion
}
