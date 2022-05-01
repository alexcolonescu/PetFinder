package petFinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petFinder.entity.Pet;
import petFinder.repository.PetRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository repo;

    public List<Pet> listAll(){

        return repo.findAll();
    }

    public void save(Pet pet){
        repo.save(pet);
    }

    public Pet get(Long id){
     return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }


}
