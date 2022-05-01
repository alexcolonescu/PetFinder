package petFinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private boolean vaccinated;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

    @Column
    private boolean available;

    @Column
    private LocalDateTime dateIn;

    @ManyToMany
    @JoinTable(
            name = "pet_owners",
            joinColumns = @JoinColumn(name = "pets_id"),
            inverseJoinColumns = @JoinColumn(name = "owners_id")
    )
    private Set<Owner> owners;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = City.class)
    private Set<City> city;

    @ManyToOne
    private MyUser user;
}


