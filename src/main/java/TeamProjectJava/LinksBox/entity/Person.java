package TeamProjectJava.LinksBox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

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
    private List<Catalog> catalogs = new LinkedList<>();

    public Person(String firstName, String lastName, @Email String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void addCatalog(Catalog catalog){
        catalog.setOwner(this);
        catalogs.add(catalog);
    }

    public void addAllCatalogs(){
        List<Catalog> list = Catalog.createRootCatalogs();
        for (Catalog catalog:list) {
            addCatalog(catalog);
        }
    }
}
