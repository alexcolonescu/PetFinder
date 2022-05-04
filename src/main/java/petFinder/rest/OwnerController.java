package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import petFinder.entity.Owner;
import petFinder.repository.OwnerRepository;
import petFinder.repository.PetRepository;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;


    @GetMapping(value = "/owner/all")
    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    @PostMapping(value = "/owner")
    public void saveOwner(@RequestBody Owner owner){
        ownerRepository.save(owner);
    }

}
