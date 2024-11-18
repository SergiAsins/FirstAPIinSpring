package org.factoriaf5.first_api;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class FirstController {

    @GetMapping()
    public String sayHi() {
        return "hola";
    }

    @PostMapping()
    public String sayHi2(@RequestBody String name) {
        return "Hello by POST: " + name;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return "Would you like to delete this item?";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody String name){
        return "you are goint to update: " + name;
    }
}