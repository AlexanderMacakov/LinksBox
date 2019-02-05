package TeamProjectJava.LinksBox.repos;

import TeamProjectJava.LinksBox.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long>{
    public Person findByEmail(String email);
}
