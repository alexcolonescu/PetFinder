package petFinder.entity;


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
    private Set<Pet> pets;

    @OneToOne
    private ContactDetails contactDetails;
}
