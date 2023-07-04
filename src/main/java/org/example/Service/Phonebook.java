package org.example.Service;

import org.example.Models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    public static List<Person> contactList;
    public HashMap<String, List<Integer>> searchByName;
    public HashMap<Long, Integer> searchByNumber;


    public  static void printPersonAge(Person person){
        System.out.println(person.getName()+" is "+person.getAge()+" years old.");
    }
    public static Person addToPersonAge(Person person) {
        int age = person.getAge();
        person.setAge(age+1);
        return person;
    }


    public void addContact(Person contactInfo){
        //Lazy loading
        contactList = contactList==null?new ArrayList<>():contactList;
        searchByName = searchByName== null?new HashMap<>():searchByName;
        searchByNumber = searchByNumber== null?new HashMap<>():searchByNumber;

        contactList.add(contactInfo);

        Integer index = contactList.indexOf(contactInfo);
        if (searchByName.get(contactInfo.getName())==null) {
            List<Integer> indices = new ArrayList<>();
            indices.add(index);
            searchByName.put(contactInfo.getName(), indices);
        }
        else{
            searchByName.get(contactInfo.getName()).add(index);
        }
        searchByNumber.put(contactInfo.getPhoneNumber(), index);
    }


}
