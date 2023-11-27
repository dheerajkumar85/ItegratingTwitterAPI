package com.Integrate.twitter.apis.controller;

import com.Integrate.twitter.apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class Controller {


    @Autowired
    UserService userService;

    @Value("${jwt.token}")
    private String bearerToken;


    @GetMapping(value ="fetchUserDetailsByUserName/{username}")
    public String getUsers(@PathVariable String usernames, String bearerToken) throws IOException, URISyntaxException {

        String users = userService.getUsers(usernames, bearerToken);
        return users;
    }
}
