package testovoe.naumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testovoe.naumen.model.PersonOut;

@Repository
public interface PersonOutRepository extends JpaRepository<PersonOut, Integer> {
    PersonOut findByPersonName(String name);
}
