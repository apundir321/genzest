package com.howtodoinjava.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);

}
