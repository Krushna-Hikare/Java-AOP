package org.example.api;

import org.example.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {
    @Autowired
    private userService userService;
    @GetMapping("/")
    public String userLogin(){
        userService.login();
        return "User login endpoint called successfully.";
    }
}
