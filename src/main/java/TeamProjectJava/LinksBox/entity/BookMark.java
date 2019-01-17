package TeamProjectJava.LinksBox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "bookMarks")
@Data
@NoArgsConstructor
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @NotBlank(message = "Please, enter a link")
    @Column(name = "link", nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    private Person author;

    public BookMark(String title, String description, String link, Person author) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.author = author;
    }
}
