package com.bs.travelagency.dto;

public class PostStatusDTO {

    //region for private variables
    private String post;
    private Long location;
    private Integer postPrivacy;
    //endregion

    //region for constructor
    public PostStatusDTO() {
    }

    public PostStatusDTO(String post, Long location, Integer postPrivacy) {
        this.post = post;
        this.location = location;
        this.postPrivacy = postPrivacy;
    }
    //endregion

    //region for getter setter
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Integer getPostPrivacy() {
        return postPrivacy;
    }

    public void setPostPrivacy(Integer postPrivacy) {
        this.postPrivacy = postPrivacy;
    }
    //endregion
}
