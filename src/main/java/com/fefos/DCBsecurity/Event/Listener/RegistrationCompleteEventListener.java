package com.fefos.DCBsecurity.Event.Listener;

import com.fefos.DCBsecurity.Entity.User;
import com.fefos.DCBsecurity.Event.RegistrationCompleteEvent;
import com.fefos.DCBsecurity.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //Send Mail to user
        String url =
                event.getAppUrl()
                        + "VerifyRegistration?token="
                        + token;
        //Here should be send the verification email
        log.info("Click the link to verify your account; {}",url);
    }
}
