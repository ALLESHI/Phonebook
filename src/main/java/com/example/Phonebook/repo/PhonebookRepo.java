package com.example.Phonebook.repo;

import com.example.Phonebook.model.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhonebookRepo extends JpaRepository<Phonebook, Long> {
    Optional<Object> findPhoneBookByFirstName(String firstName);

    Optional<Object> findPhoneBookByLastName(String lastName);

    @Query("SELECT s FROM Phonebook s ORDER BY s.firstName")
    List<Phonebook> listByName();
    @Query("SELECT s FROM Phonebook s ORDER BY s.lastName")
    List<Phonebook> listByLastName();
}
