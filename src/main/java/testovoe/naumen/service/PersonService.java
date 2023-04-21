package testovoe.naumen.service;

import testovoe.naumen.model.Person;
import testovoe.naumen.model.PersonOut;

import java.util.ArrayList;

public interface PersonService {
    private void init() {};

    Person searchPerson(String name);

    Person findAgeUp();

    ArrayList<Person> findCountUp();

    ArrayList<PersonOut> findCountOut();
}
