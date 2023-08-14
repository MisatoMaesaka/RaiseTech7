package com.catsprofile.cats;

public class ProfileCreateResponse {
    private String message;

    public ProfileCreateResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
