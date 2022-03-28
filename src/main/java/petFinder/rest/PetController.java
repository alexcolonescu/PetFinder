package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import petFinder.entity.Pet;
import petFinder.repository.OwnerRepository;
import petFinder.repository.PetRepository;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @PostMapping(value = "/pet")
    public Pet savePet(@RequestBody Pet pet){
        return petRepository.save(pet);
    }

    @GetMapping(value = "pet/all")
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }
}
