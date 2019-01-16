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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank(message = "firstName cannot be empty")
    String firstName;
    @NotBlank(message = "lastName cannot be empty")
    String lastName;
    @Email
    @NotBlank(message = "email cannot be empty")
    String email;
    @NotBlank(message = "password cannot be empty")
    String password;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    LinkedHashSet<Catalog> catalogs;

    public Person(String firstName, String lastName, @Email String email, String password, LinkedHashSet<Catalog> catalogs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.catalogs = catalogs;
    }
}
