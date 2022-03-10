package main;

import main.entity.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getUserName(Long id) {
        User user = userRepository.getUserById(id);
        if (user != null) {
            return user.getName();
        }
        return "test fail";
    }
}
