package petFinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "contactDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private Owner owner;

    @OneToOne(mappedBy = "contactDetails")
    @JsonIgnore
    private MyUser user;
}
