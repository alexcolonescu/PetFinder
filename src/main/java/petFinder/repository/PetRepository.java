package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petFinder.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
