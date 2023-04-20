package testovoe.naumen.model;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Основная модель сервиса, для сохранения в основную таблицу
 * */

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "age")
    private int age;

    @Column(name = "count")
    private int count;

    public Person() {
    }

    public Person(String personName, int age) {
        this.personName = personName;
        this.age = age;
    }

    public Person(Integer personId, String personName, int age, int count) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
        this.count = count;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName);
    }
}
