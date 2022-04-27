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
import petFinder.service.impl.PetService;

import java.util.List;
import java.util.Set;

@Controller
public class PetController {
    @Autowired
    private PetService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Pet> listPets = service.listAll();
        model.addAttribute("listPets",listPets);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Pet pet = new Pet();
        model.addAttribute("pet",pet);

        return "new_pet";

    }
    @RequestMapping(value = "/save", method =RequestMethod.POST)
    public String petSave(@ModelAttribute("pet")Pet pet){
        service.save(pet);
        return "index";
    }


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
