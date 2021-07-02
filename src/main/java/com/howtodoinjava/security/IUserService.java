package com.howtodoinjava.security;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.howtodoinjava.dto.UserDto;
import com.howtodoinjava.model.PasswordResetToken;
import com.howtodoinjava.model.RecruiterProfile;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;
import com.howtodoinjava.model.VerificationToken;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto,boolean isRecuiter) throws com.howtodoinjava.error.UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(User user) throws UnsupportedEncodingException;

    User updateUser2FA(boolean use2FA);
    
    public List<User> getUserByRoleName(String roleName)throws Exception;
    
    public List<RecruiterProfile> getUserByRoleParams(Map<String, Object> searchCriteria)throws Exception;
    
    public List<UserProfile> getUserProfilesByRoleParams(Map<String, Object> searchCriteria)throws Exception;

//    List<String> getUsersFromSessionRegistry();

//    NewLocationToken isNewLoginLocation(String username, String ip);

    String isValidNewLocationToken(String token);
    
    public User getRecruiter(String recruiterProfileId);

//    void addUserLocation(User user, String ip);
}
