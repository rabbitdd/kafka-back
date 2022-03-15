package main.controller;

import main.entity.User;
import main.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {

    @Autowired
    CustomerUserDetailService customerUserDetailService;


    @PostMapping("/auth")
    public String getLoginPage(@RequestParam String login, @RequestParam String password) {
        System.out.println("****");
        UserDetails securityUser = customerUserDetailService.loadUserByUsername(login);
        if (securityUser != null) {
            if (securityUser.getPassword().equals(password)) {
                System.out.println("User exist");
                return "true";
            }
            return "incorrectPassword";
        }
        else {
            System.out.println("User doesn't exist");
            System.out.println("POST request ... ");
            return "false";
        }
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println("sdsdsd");
        String hashPassword = new BCryptPasswordEncoder(12).encode(user.getPassword());
        user.setPassword(hashPassword);
        return customerUserDetailService.addUser(user);
    }
    @GetMapping("/auth")
    public String getAuth() {
        return "auth";
    }
}
