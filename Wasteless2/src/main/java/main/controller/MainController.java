package main.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> findItemsByIdList() {
        return new ResponseEntity<>("IT WORKS", HttpStatus.OK);
    }
}
