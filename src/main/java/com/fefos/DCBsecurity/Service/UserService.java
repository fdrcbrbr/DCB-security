package com.fefos.DCBsecurity.Service;

import com.fefos.DCBsecurity.Entity.User;
import com.fefos.DCBsecurity.Model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
