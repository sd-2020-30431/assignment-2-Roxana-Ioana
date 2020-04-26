package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import main.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/authenticate")
public class UserController {

    private final UserService userService;
    private UserMapper userMapper;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = new UserMapper();
        userValidator = new UserValidator();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> findUser(@RequestBody UserDTO userDTO) {
        Optional<User> foundUser = userService.findUser(userDTO.getUsername(), userDTO.getPassword());
        return foundUser.map(user -> new ResponseEntity<>(foundUser.get().getIdUser(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO) {
        try {
            userValidator.validate(userDTO);
            User user = userService.createUser(userMapper.convertToUser(userDTO));
            return new ResponseEntity<>(user.getIdUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
