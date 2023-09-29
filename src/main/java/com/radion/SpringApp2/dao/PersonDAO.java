package com.radion.SpringApp2.dao;

import com.radion.SpringApp2.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT = 1;
    List<Person> peopleList;
    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(COUNT++, "Sergey"));
        peopleList.add(new Person(COUNT++, "Angel"));
        peopleList.add(new Person(COUNT++, "Phone"));
    }
    public List<Person> getPeopleList(){
        return peopleList;
    }
    public Person getOnePeople(int id){
       return peopleList.stream().filter(people -> people.getID() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setID(COUNT++);
        peopleList.add(person);
    }
}
