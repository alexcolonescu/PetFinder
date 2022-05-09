package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import petFinder.entity.Owner;
import petFinder.repository.OwnerRepository;
import petFinder.service.owner.OwnerService;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(path="/owners_csv")
    public String setDataInDb(){
        ownerService.saveOwnerData();
        return "redirect:/owners";
    }

    @GetMapping("/owners")
    public String listOwners(Model model){
        List<Owner> listOwners = repository.findAll();
        model.addAttribute("listOwners", listOwners);
        return "owners";
    }

    @GetMapping("/new_owners")
    public String showOwnerNewForm(Model model){
        model.addAttribute("owner", new Owner());
        return "owner_form";
    }

    @PostMapping("/save_owners")
    public String saveOwner(Owner owner){
        repository.save(owner);
        return "redirect:/owners";
    }
}
