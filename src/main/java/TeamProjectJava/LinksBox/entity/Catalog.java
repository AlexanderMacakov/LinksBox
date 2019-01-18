package TeamProjectJava.LinksBox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;

@Entity
@Data
@NoArgsConstructor
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "catalog_name", nullable = false)
    private String catalogName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    private Person owner;

    LinkedHashSet<Catalog> catalogs;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    LinkedHashSet<Link> links;

}
