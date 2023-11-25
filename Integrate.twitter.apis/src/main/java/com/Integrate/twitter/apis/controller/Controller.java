package com.Integrate.twitter.apis.controller;

import com.Integrate.twitter.apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class Controller {


    @Autowired
    UserService userService;

    @GetMapping("/{usernames}")
    public String getUsers(@RequestParam String usernames, @RequestParam String bearerToken) throws IOException, URISyntaxException {

        String users = userService.getUsers(usernames, bearerToken);
        return users;
    }
}
