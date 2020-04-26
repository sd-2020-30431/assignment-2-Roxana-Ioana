package main.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity findItemsByIdList() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
