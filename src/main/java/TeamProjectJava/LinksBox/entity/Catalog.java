package TeamProjectJava.LinksBox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "catalog_name", nullable = false)
    private String catalogName;
    @ManyToOne
    private Catalog parent;
    @OneToMany
    private List<Catalog> children;

//    @OneToMany(mappedBy = "catalog_id", cascade = CascadeType.ALL)
//    private LinkedList<Bookmark> links;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person owner;

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        this.parent = null;
        this.children = new LinkedList<>();
//        this.links = new LinkedList<>();
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void addChild(Catalog child){
        child.setParent(this);
        this.children.add(child);
    }

//    public void addLink(Bookmark link){
//        links.add(link);
//    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Catalog getParent() {
        return parent;
    }

    public void setParent(Catalog parent) {
        this.parent = parent;
    }

    public List<Catalog> getChildren() {
        return children;
    }

//    public LinkedList<Bookmark> getLinks() {
//        return links;
//    }

    public static LinkedList<Catalog> createRootCatalogs(){
        LinkedList<Catalog> rootCatalogs = new LinkedList<>();
        Catalog root = new Catalog("ROOT");
        Catalog news = new Catalog("News");
        Catalog games = new Catalog("Games");
        Catalog etc = new Catalog("Etc");
        root.addChild(news);
        root.addChild(games);
        root.addChild(etc);
        rootCatalogs.add(root);
        rootCatalogs.add(news);
        rootCatalogs.add(games);
        rootCatalogs.add(etc);
        return rootCatalogs;
    }

    @Override
    public String toString() {
        return catalogName;
    }
}
