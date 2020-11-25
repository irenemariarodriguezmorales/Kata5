package kata5.persistence.sql;

import kata5.persistence.PeopleLoader;
import kata5.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlitePeopleLoader implements PeopleLoader {
    public SqlitePeopleLoader() {
    }

    @Override
    public List<Person> load() {
        List<Person> lista = new ArrayList();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
            
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM people");
            while(set.next()){
                String name = set.getString("first_name")+set.getString("last_name");
                String address = set.getString("address");
                String email = set.getString("email");
                lista.add(new Person(name, address, email));
            }
            return lista;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    } 
}
