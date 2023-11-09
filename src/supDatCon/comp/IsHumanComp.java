package supDatCon.comp;
import java.util.Comparator;
import supDatCon.Superhero;

public class IsHumanComp implements Comparator <Superhero> {
    public int compare(Superhero s1, Superhero s2) {
        return Boolean.compare(s1.isHuman(), s2.isHuman());
    }
}

