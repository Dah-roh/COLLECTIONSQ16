package org.example.Service;

import org.example.Models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    public static List<Person> contactList;
    public static HashMap<String, List<Integer>> searchByName;
    static HashMap<Long, Integer> searchByNumber;

    public static void addContact (Person contactInfo){
        contactList = contactList== null?new ArrayList<>():contactList;
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
