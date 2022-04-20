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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @ToString.Exclude
    @ManyToMany(mappedBy = "owners")
    @JsonIgnore
    private Set<Pet> pets;

}
