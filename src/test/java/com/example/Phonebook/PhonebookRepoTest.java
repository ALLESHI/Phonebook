package com.example.Phonebook;

import com.example.Phonebook.model.Phonebook;
import com.example.Phonebook.repo.PhonebookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PhonebookRepoTest {

    @Autowired
    private PhonebookRepo phonebookRepo;

    @Test
    public void createContactTest(){
        Phonebook phonebook = new Phonebook();
    }
}
