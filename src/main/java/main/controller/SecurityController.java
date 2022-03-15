package main.controller;

import main.entity.User;
import main.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    CustomerUserDetailService customerUserDetailService;


    @PostMapping("/auth")
    public String getLoginPage(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println("****");
        UserDetails securityUser = customerUserDetailService.loadUserByUsername(user.getLogin());
        System.out.println("****");
        return "true";
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
        return "{\"auth\": \"auth\"}";
    }
}
