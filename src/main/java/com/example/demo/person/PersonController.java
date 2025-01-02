package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<String> addPersonInAGetRequestToSimplifyExample() {
        //you get nothing just a dumb example and this doesn't apply to what I am showing.  Or it would be
        //a post, and you would get the person you added in return. This just proves you can save when you run
        //the app.  Easier for you if that is a simple GET request in your browser.
        personService.addPerson();
        return new ResponseEntity<>("Congrats, person was added", HttpStatus.OK);
    }
}
