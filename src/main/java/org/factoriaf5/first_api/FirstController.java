package org.factoriaf5.first_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class FirstController {

    @GetMapping
    public String sayHi() {
        return "Hi!";
    }

    @PostMapping
    public String sayHiTwo(@RequestBody String name) {
        return "Hi by post: " + name;
    }
}