package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petFinder.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
