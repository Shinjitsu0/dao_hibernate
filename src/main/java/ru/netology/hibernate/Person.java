package ru.netology.hibernate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person implements Serializable {

    @Id
    @Column
    private String name;

    @Id
    @Column
    private String surname;

    @Id
    @Column
    private int age;

    @Column
    private String phoneNumber;

    @Column
    private String cityOfLiving;

}
