package testovoe.naumen.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Дополнительная модель сервиса, для сохранения статистики оп именам, которых нет в файле в дополнительную таблицу
 * */
@Entity
@Table(name = "personOut")
public class PersonOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name", columnDefinition = "VARCHAR(255) CHARACTER SET utf8")
    private String personName;

    @Column(name = "count")
    private int count;

    public PersonOut() {
    }

    public PersonOut(String personName, int count) {
        this.personName = personName;
        this.count = count;
    }

    public PersonOut(Integer personId, String personName, int count) {
        this.personId = personId;
        this.personName = personName;
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
        PersonOut personOut = (PersonOut) o;
        return Objects.equals(personId, personOut.personId) && Objects.equals(personName, personOut.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName);
    }

    @Override
    public String toString() {
        return "PersonOut{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", count=" + count +
                '}';
    }
}