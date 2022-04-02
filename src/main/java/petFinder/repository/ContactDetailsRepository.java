package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petFinder.entity.ContactDetails;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails,Long> {
    ContactDetails findByPhoneNumber(String phoneNumber);
}
