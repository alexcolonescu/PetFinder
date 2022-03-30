package petFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import petFinder.entity.Pet;

import java.util.Set;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Set<Pet> findByBreedLike(String breed);

}
