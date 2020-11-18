package br.edu.uniso.apidog.controller;

import br.edu.uniso.apidog.dto.Dog;
import br.edu.uniso.apidog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DogController {
    @Autowired
    DogService service;

    @GetMapping("/dogs")
    public List<Dog> listDogs(){
        return service.listAll();
    }

    @GetMapping("/dogs/{id}")
    public Dog getDog(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping("/dogs")
    public void addDog(@RequestBody Dog dog){
        dog.setCreatedAt(new Date());
        service.save(dog);
    }

    @GetMapping("/welcome")
    public String Welcome(){
        return "Welcome to dogapi";
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity<?> updateDog(@RequestBody Dog dog, @PathVariable Integer id){
        Dog exists = service.get(id);

        if(exists!=null){
            service.save(dog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
