package TeamProjectJava.LinksBox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "firstName cannot be empty")
    @Column (name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @NotBlank(message = "email cannot be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private LinkedHashSet<Catalog> catalogs;

    public Person(String firstName, String lastName, @Email String email, String password, LinkedHashSet<Catalog> catalogs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.catalogs = catalogs;
    }
}
