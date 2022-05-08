package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import petFinder.entity.Owner;
import petFinder.entity.Pet;
import petFinder.repository.OwnerRepository;
import petFinder.repository.PetRepository;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    // TBM in pets
    @GetMapping("/index-pets")
    public String viewPets(Model model){
        List<Pet> petList = petRepository.findAll();
        model.addAttribute("petList", petList);
        return "index-pets";
    }

    @GetMapping("/new_pet")
    public String showNewPetForm(Model model){
        List<Owner> listOwners = ownerRepository.findAll();
        model.addAttribute("pet", new Pet());
        model.addAttribute("listOwners", listOwners);
        return "pet_form";
    }

    @PostMapping("/save_pet")
    public String savePet(Pet pet, RedirectAttributes redirectAttributes, HttpServletRequest request){
        pet.setDate(LocalDateTime.now());
        petRepository.save(pet);
        redirectAttributes.addFlashAttribute("message", "The pet has been saved successfully");
        return "redirect:/pets";
    }

    @GetMapping("/pets")
    public String listPets(Model model){
        List<Pet> petList = petRepository.findAll();
        model.addAttribute("petList", petList);
        return "pets";


    }

    @GetMapping("/edit_pets/{id}")
    public String showEditPetForm(@PathVariable("id") Integer id, Model model){
        Pet pet = petRepository.findById(id).get();
        model.addAttribute("pet", pet);
        List<Owner> listOwners = ownerRepository.findAll();
        model.addAttribute("listOwners", listOwners);
        return "pet_form";
    }

    @GetMapping("delete_pet/{id}")
    public String deletePet(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        petRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "The pet with ID " + id + " has been deleted.");
        return "redirect:/pets";
    }

}
