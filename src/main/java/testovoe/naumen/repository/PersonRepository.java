package testovoe.naumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testovoe.naumen.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByPersonName(String name);

    @Query("SELECT p FROM Person p WHERE p.age = (SELECT MAX(p2.age) FROM Person p2)")
    Person findOldPerson();
}
