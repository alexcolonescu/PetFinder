package petFinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petFinder.entity.Owner;
import petFinder.repository.OwnerRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    String line = "";

    public void saveOwnerData(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/Owners.csv"));
            while((line=br.readLine())!=null){
                String [] data = line.split(";");
                Owner owner = new Owner();
                owner.setName(data[0]);
                owner.setEmail(data[1]);
                owner.setPhoneNumber(data[2]);
                ownerRepository.save(owner);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add scheduling job (5:48 from https://www.youtube.com/watch?v=uxV-3947fiM)

}
