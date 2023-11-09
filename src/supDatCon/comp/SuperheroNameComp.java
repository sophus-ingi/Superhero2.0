package supDatCon.comp;
import supDatCon.Superhero;
import java.util.Comparator;

public class SuperheroNameComp implements Comparator<Superhero> {
    public int compare(Superhero s1, Superhero s2){
        return s1.getName().compareTo(s2.getName());
    }
}
