package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petFinder.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByLastNameAndFirstName(String lastName, String firsName);

}
