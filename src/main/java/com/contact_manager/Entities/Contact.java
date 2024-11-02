package com.contact_manager.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    private String work;
    private String home;
    private String birthday;
    private String sociallink;
    private String relationship;

    @ManyToOne
    private User user;
}

/*
{
    "name": "11",
    "number": "11",
    "work": "11",
    "home": "11",
    "birthday": "11",
    "sociallink": "11",
    "relationship": "11"
}
*/