package petFinder.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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
    private Integer id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private boolean vaccinated;

    @Column(nullable = false)
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = City.class)
    private Set<City> city;
}


