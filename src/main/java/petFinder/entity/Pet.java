package petFinder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Breed.class)
    private Set<Breed> breed;

    @ManyToMany
    private Set<Owner> owners;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private boolean vaccinated;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

}
