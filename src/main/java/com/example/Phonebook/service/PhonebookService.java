package com.example.Phonebook.service;

import com.example.Phonebook.model.Phonebook;

import java.util.List;

public interface PhonebookService {
    Phonebook createContact(Phonebook phoneBook);
    Phonebook findByID(Long id);
    Phonebook findByFirstName(String firstName);
    Phonebook findByLastName(String lastName);
    List<Phonebook> showAllContactsList();
    Phonebook updateContact(Phonebook phonebook, Long phonebookID);
    void deleteContactById(Long phonebookID);
    List<Phonebook> listByName();
    List<Phonebook> listByLastName();
}