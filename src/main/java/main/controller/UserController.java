package main.controller;


import lombok.Data;
import lombok.NoArgsConstructor;
import main.service.CustomerUserDetailService;
import main.service.DocumentService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerUserDetailService customerUserDetailService;


    @GetMapping("/user/id")
    String getUserId(@RequestParam String login){
        return userService.getUserId(login).toString();
    }

    @PostMapping("/check")
    String checkUser(@RequestBody AuthUser user){
        UserDetails securityUser = customerUserDetailService.loadUserByUsername(user.login);
        if (securityUser != null) {
            if (securityUser.getPassword().equals(user.password)) {
                System.out.println("User exist");
                return "{\"token\": \"true\"}";
            }
            return "{\"token\": \"bad\"}";
        } else {
            System.out.println("User doesn't exist");
            System.out.println("POST request ... ");
            return "{\"token\": \"bad\"}";
        }
    }

    @Data
    @NoArgsConstructor
    public static class AuthUser {
        String login;
        String password;
    }
}
