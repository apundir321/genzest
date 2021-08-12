package com.howtodoinjava.dto;

import com.howtodoinjava.validation.ValidPassword;

public class ForgotPasswordDto {

    private  String token;

    @ValidPassword
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
