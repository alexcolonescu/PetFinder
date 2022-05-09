package petFinder.service.owner;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import petFinder.entity.Owner;
import petFinder.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    String line = "";

    Logger log = LoggerFactory.getLogger(OwnerService.class);

    /**
     * Importing CSV file into SQL database
     */
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

    /**
     * Schedule to add into the Owners database some random Owners
     * Using Faker library
     */
    @Scheduled(fixedRate = 60000)
    public void addOwner(){
        Owner owner= new Owner();
        Faker faker = new Faker();
        String namesRandom  = faker.name().fullName().toString().toLowerCase(Locale.ROOT);
        owner.setName(String.valueOf(namesRandom));
        owner.setEmail(owner.getName().replaceAll("\\s", "") + "@yahoo.com");
        owner.setPhoneNumber("0734567" + new Random().nextInt(9) +new Random().nextInt(9) + new Random().nextInt(9));
        ownerRepository.save(owner);
        System.out.println("Add service call in " + new Date().toString() );
    }

    @Scheduled(cron = "0/15 * * * * * ")
    public void fetchDBJob(){
        List<Owner> owners = ownerRepository.findAll();
        System.out.println("Fetch service call in  " + new Date().toString() );
        System.out.println("No of record fetched "+ owners.size());
        log.info("Owner : {}", owners);
    }
}
