package com.example.Phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Phonebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_Book_ID", nullable = false, updatable = false)
    private long phoneBookID;
    private String firstName;
    private String lastName;
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
}
