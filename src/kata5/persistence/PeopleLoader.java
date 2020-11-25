package kata5.persistence;

import kata5.model.Person;
import java.util.List;

public interface PeopleLoader {
    public List<Person> load();
}
