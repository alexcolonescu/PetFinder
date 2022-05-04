package petFinder.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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
    @Column(name = "pet_id")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "pet_owners",
            joinColumns = @JoinColumn(name = "pets_id"),
            inverseJoinColumns = @JoinColumn(name = "owners_id")
    )
    private Set<Owner> owners = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = City.class)
    private Set<City> city;

    @ManyToOne
    private User user;
}


