package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
