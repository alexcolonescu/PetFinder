package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petFinder.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
