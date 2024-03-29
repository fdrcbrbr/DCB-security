package com.fefos.DCBsecurity.Controller;

import com.fefos.DCBsecurity.Entity.User;
import com.fefos.DCBsecurity.Event.RegistrationCompleteEvent;
import com.fefos.DCBsecurity.Model.UserModel;
import com.fefos.DCBsecurity.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel,
                               final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "User inserted";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
