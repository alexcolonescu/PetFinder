package petFinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petFinder.entity.Owner;
import petFinder.repository.OwnerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OwnerService {

    @Autowired
    private OwnerRepository repos;

    public List<Owner> listAll(){

        return repos.findAll();
    }

    public void save(Owner owner){
        repos.save(owner);
    }

    public Owner get(Long id){
        return repos.findById(id).get();
    }

    public void delete(Long id){
        repos.deleteById(id);
    }


}

