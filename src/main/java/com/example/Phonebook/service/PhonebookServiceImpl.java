package com.example.Phonebook.service;

import com.example.Phonebook.exception.ContactNotFoundException;
import com.example.Phonebook.model.Phonebook;
import com.example.Phonebook.repo.PhonebookRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
@Service
public class PhonebookServiceImpl implements PhonebookService {
    private final PhonebookRepo phonebookRepo;

    public PhonebookServiceImpl(PhonebookRepo phonebookRepo) {
        this.phonebookRepo = phonebookRepo;
    }
    @Override
    public Phonebook createContact(Phonebook phoneBook) {
        return phonebookRepo.save(phoneBook);
    }
    @Override
    public Phonebook findByID(Long id) {
        return phonebookRepo.findById(id).orElseThrow(() -> new ContactNotFoundException(
                "Contact with id " + id + " was not found!"));
    }
    @Override
    public Phonebook findByFirstName(String firstName) {
        return (Phonebook) phonebookRepo.findPhoneBookByFirstName(firstName).orElseThrow(() -> new ContactNotFoundException(
                "Contact with name " + firstName + " was not found!"));
    }
    @Override
    public Phonebook findByLastName(String lastName) {
        return (Phonebook) phonebookRepo.findPhoneBookByLastName(lastName).orElseThrow(() -> new ContactNotFoundException(
                "Contact with lastName " + lastName + " was not found!"));
    }
    @Override
    public List<Phonebook> showAllContactsList() {
        return phonebookRepo.findAll();
    }
    @Override
    @Transactional
    public Phonebook updateContact(Phonebook phonebook, Long phonebookID) {
        Phonebook phone = phonebookRepo.findById(phonebookID).orElseThrow(() -> new IllegalStateException("Contact with id " + phonebookID + " does not exist!"));
        if (Objects.nonNull(phonebook.getFirstName()) && !"".equalsIgnoreCase(phonebook.getFirstName()))
        {phone.setFirstName(phonebook.getFirstName());
        }
        if (Objects.nonNull(phonebook.getLastName()) && !"".equalsIgnoreCase(phonebook.getLastName()))
        {phone.setLastName(phonebook.getLastName());
        }
        if (Objects.nonNull(phonebook.getNumber()) && !"".equalsIgnoreCase(phonebook.getNumber()))
        {phone.setNumber(phonebook.getNumber());
        }
        if (Objects.nonNull(phonebook.getPhoneType()) && (phonebook.getPhoneType() != phone.getPhoneType()))
        {phone.setPhoneType(phonebook.getPhoneType());
        }
        return phonebookRepo.save(phone);
    }
    @Override
    public void deleteContactById(Long phonebookID) {
        phonebookRepo.deleteById(phonebookID);
    }
    @Override
    public List<Phonebook> listByName() {
        return phonebookRepo.listByName();
    }
    @Override
    public List<Phonebook> listByLastName() {
        return phonebookRepo.listByLastName();
    }
}
