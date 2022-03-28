package petFinder.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ToString.Exclude
    @ManyToMany(mappedBy = "owners")
    @JsonIgnore
    private Set<Pet> pets;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;
}
