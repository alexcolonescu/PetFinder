package petFinder.entity;

import javax.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 30, unique = true)
    private String phoneNumber;

    public Owner(){
    }

    public Owner(Integer id){
        this.id = id;
    }

    public Owner(String name){
        this.name = name;
    }

    public Owner(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){ return email;}

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber(){ return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return name;
    }
}
