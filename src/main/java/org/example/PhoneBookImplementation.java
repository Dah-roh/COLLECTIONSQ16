package org.example;

import org.example.Models.Person;
import org.example.Service.Phonebook;

public class PhoneBookImplementation {
    public static void main(String[] args) {
        Person oghenekevwe = new Person("Oghenekevwe", 35, 23498678474l);
        Person patricia = new Person("Patricia", 45, 23498668474l);
        Person olatunji = new Person("Olatunji", 55, 23498668554l);
        Person patricia2 = new Person("Patricia", 95, 23498668334l);

        Phonebook phonebook = new Phonebook();
        phonebook.addContact(oghenekevwe);
        phonebook.addContact(patricia);
        phonebook.addContact(olatunji);
        phonebook.addContact(patricia2);

        Person searchResult = Phonebook.contactList.get(phonebook.searchByNumber.get(23498668554l));

        phonebook.searchByName.get("Patricia").forEach(index -> {
            System.out.println("Search Name return: "+Phonebook.contactList.get(index));
        });

        System.out.println("Search Number return: "+searchResult);
    }
}
