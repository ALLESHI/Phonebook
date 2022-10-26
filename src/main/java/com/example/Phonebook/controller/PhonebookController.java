package com.example.Phonebook.controller;

import com.example.Phonebook.model.Phonebook;
import com.example.Phonebook.service.PhonebookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneBook")
public class PhonebookController {

    private final PhonebookServiceImpl phonebookServiceImpl;

    public PhonebookController(PhonebookServiceImpl phonebookServiceImpl) {
        this.phonebookServiceImpl = phonebookServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<Phonebook> createContact(@RequestBody Phonebook phonebook){
        Phonebook newContact = phonebookServiceImpl.createContact(phonebook);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public Phonebook updateContact(@RequestBody Phonebook phonebook, @PathVariable("id") Long id){
        return phonebookServiceImpl.updateContact(phonebook, id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Phonebook> getContactById(@PathVariable("id") Long id){
        Phonebook phonebook = phonebookServiceImpl.findByID(id);
        return new ResponseEntity<>(phonebook, HttpStatus.OK);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public ResponseEntity<Phonebook> findByFirstName(@PathVariable("firstName") String firstName){
        Phonebook phonebook = phonebookServiceImpl.findByFirstName(firstName);
        return new ResponseEntity<>(phonebook, HttpStatus.OK);
    }

    @GetMapping("/findByLastName/{lastName}")
    public ResponseEntity<Phonebook> findByLastName(@PathVariable("lastName") String lastName){
        Phonebook phonebook = phonebookServiceImpl.findByLastName(lastName);
        return new ResponseEntity<>(phonebook, HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Phonebook>> getAllContact(){
        List<Phonebook> phonebooks = phonebookServiceImpl.showAllContactsList();
        return new ResponseEntity<>(phonebooks, HttpStatus.OK);
    }

    @GetMapping("/listByName")
    public ResponseEntity<List<Phonebook>> listByName(){
        List<Phonebook> phonebooks = phonebookServiceImpl.listByName();
        return new ResponseEntity<>(phonebooks, HttpStatus.OK);
    }

    @GetMapping("/listByLastName")
    public ResponseEntity<List<Phonebook>> listByLastName(){
        List<Phonebook> phonebooks = phonebookServiceImpl.listByLastName();
        return new ResponseEntity<>(phonebooks, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id){
        phonebookServiceImpl.deleteContactById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
