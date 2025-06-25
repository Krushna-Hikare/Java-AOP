package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Getter
    @Setter
    @AllArgsConstructor
    public class User{
        private String name;
        private int age;
        private String address;
    }

    public User user;

    public userService(){
        user= new User("Sachin", 23, "Pune");
    }

    public void login(){
        System.out.println("login");
    }

    public void logout() throws Exception {
        System.out.println("logout");
        throw new Exception("Unable to logout");
    }
}
