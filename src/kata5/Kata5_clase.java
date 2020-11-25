package kata5;

import kata5.ui.swing.SwingHistogramDisplay;
import kata5.ui.persistence.HistogramDisplay;
import kata5.persistence.sql.SqlitePeopleLoader;
import kata5.persistence.PeopleLoader;
import kata5.model.Histogram;
import java.sql.*;

public class Kata5_clase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PeopleLoader peopleLoader = new SqlitePeopleLoader(); // Cargador de personas
        Histogram<String> histogram = new Histogram();
        peopleLoader.load().forEach((p) -> {
            histogram.increment(p.getEmailDomain());
        });
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Prueba", histogram);
        histogramDisplay.execute();
    }
}
