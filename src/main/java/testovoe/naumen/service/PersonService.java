package testovoe.naumen.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import testovoe.naumen.model.Person;
import testovoe.naumen.model.PersonOut;
import testovoe.naumen.repository.PersonOutRepository;
import testovoe.naumen.repository.PersonRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final FileService fileService;
    private final PersonRepository personRepository;
    private final PersonOutRepository personOutRepository;


    @PostConstruct
    private void init() {
        ArrayList<Person> listPerson = fileService.loadFile();
        for (Person person : listPerson) {
            if (personRepository.findByPersonName(person.getPersonName()) == null)
                personRepository.save(person);
        }
    }

    public Person searchPerson(String name) {
       Person person = personRepository.findByPersonName(name);
       if (person == null){
           person = new Person(name, name.hashCode());
           PersonOut personOut = personOutRepository.findByPersonName(name);
           if (personOut == null){
               personOutRepository.save(new PersonOut(name, 1));
           } else {
               personOut.setCount(personOut.getCount() + 1);
               personOutRepository.save(personOut);
           }

       } else{
           person.setCount(person.getCount() + 1);
           personRepository.save(person);
        }
        return person;
    }

    public Person findAgeUp() {
        return personRepository.findOldPerson();
    }

    public ArrayList<Person> findCountUp() {
        return (ArrayList<Person>) personRepository.findAll(Sort.by(Sort.Direction.DESC, "count"));
    }

    public ArrayList<PersonOut> findCountOut() {
        return (ArrayList<PersonOut>) personOutRepository.findAll(Sort.by(Sort.Direction.DESC, "count"));
    }
}


