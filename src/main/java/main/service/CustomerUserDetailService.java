package main.service;

import main.entity.User;
import main.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomerUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.getUserByLogin(login);
        if(!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOptional.get();
        System.out.println(user.toString());
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    public String addUser(User user) {
        try {
            user.setRole("USER");
            userRepository.save(user);
            return "add";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "notAdd";
    }
}
