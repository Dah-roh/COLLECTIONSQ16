package org.example;

import org.example.Models.Person;
import org.example.Service.Phonebook;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FunctionalInterface {

    public static void main(String[] args) {
        CustomFunctionalInterface<Person> saveContact = Phonebook::addContact;
        Person person = new Person("King", 150, 23498674424l );
        Person person1 = new Person("Queen", 15, 23498674424l );
        Person person2 = new Person("Princess", 10, 23498674424l );

        saveContact.save(person);

        Arrays.asList(1, 2, 4, 56, 67, 7, 77).stream().forEach(
                System.out::println

        );

        Arrays.asList(person, person1, person2).stream().forEach(
                    Phonebook::printPersonAge

        );

        List<Person> personList = Arrays.asList(person, person1, person2);
        personList = personList.stream().map(
                Phonebook::addToPersonAge

        ).collect(Collectors.toList());
        System.out.println(personList);
    }
}
