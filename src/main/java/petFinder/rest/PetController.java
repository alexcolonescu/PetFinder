package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petFinder.entity.ContactDetails;
import petFinder.entity.Owner;
import petFinder.entity.Pet;
import petFinder.exceptions.ContactsAlreadyExist;
import petFinder.repository.ContactDetailsRepository;
import petFinder.repository.OwnerRepository;
import petFinder.repository.PetRepository;

import java.util.List;
import java.util.Set;

@Controller
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @PostMapping(value = "/pet")
    public String savePet(@RequestBody Pet pet){
        for (Owner owner: pet.getOwners()) {
            ContactDetails foundContact = contactDetailsRepository.findByPhoneNumber(owner.getContactDetails().getPhoneNumber());
            if(foundContact != null) {
                //throw new ContactsAlreadyExist("Contacts already exist");
                owner.setContactDetails(foundContact);
                owner.setId(foundContact.getOwner().getId());
            }
            else {
                owner.setContactDetails(contactDetailsRepository.save(owner.getContactDetails()));
                ownerRepository.save(owner);
            }
        }

        petRepository.save(pet);

        return "all-pets";
    }

    @GetMapping(value = "/pet/all")
    public String getAllPets(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "all-pets";
    }

    @DeleteMapping(value = "/pet/{id}")
    public void deletePet(@PathVariable Long id){
        petRepository.deleteById(id);
    }

    @GetMapping(value = "/pet/breed")
    public Set<Pet> getPetByBreed(@RequestParam(name = "breed") String breed){
        return petRepository.findByBreedContaining(breed);
    }


}
