package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = new UserMapper();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> findUser(@RequestBody UserDTO userDTO) {
        Optional<User> foundUser = userService.findUser(userDTO.getUsername(), userDTO.getPassword());
        return foundUser.map(user -> new ResponseEntity<>(foundUser.get().getIdUser(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED));
    }
}
