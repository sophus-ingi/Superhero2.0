package supDatCon;
import java.util.Collections;
import java.util.Comparator;
import supDatCon.Superhero;

import java.util.ArrayList;

public class Controller {
    private Database db;
    private FileHandler fh;



    public Controller(Database db) {
        this.db = db;
    }

    public ArrayList<Superhero> findAllSuperhero(String search) {
        return db.findAllSuperhero(search);

    }


    public Superhero findSuperhero(String search) {
        return db.findSuperhero(search);
    }

    public ArrayList<Superhero> getDatabase() {

        return db.getDatabase();
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        db.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
    }

    public void sortSuperheroes(String sortBy) {
        ArrayList<Superhero> superheroes = db.getDatabase();
        System.out.println(superheroes);
        switch (sortBy.toLowerCase()) {
            case "name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getName));
                break;
            case "real name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getRealName));
                break;
            case "superpower":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getSuperPower));
                break;
            case "year created":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getYearCreated));
                break;
            //case "is human":
                //Collections.sort(superheroes, Comparator.comparing(Superhero::getIshuman);
               // break;
            case "strength":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getStrength));
                break;
            case "strength and real name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getStrength).thenComparing(Superhero::getRealName).reversed());
                break;
            default:
                System.out.println("Invalid sorting attribute");
                return;

        }
        System.out.println(superheroes);
        db.setDatabase(superheroes);

    }

    public int size() {
        return db.size();
    }

    public Superhero get(int index) {
        return get(index);
    }


    public void removeSuperhero(int index) {
        db.removeSuperhero(index);
    }

    public void printStartMessage(){
        System.out.println("START MESSAGE!");
    }

    public void editSuperheroDetails(){

    }
    public void loadSuperheroes(ArrayList<Superhero> database){
        fh.loadSuperheroes(database);
    }

    public void save(){
        db.save();
    }
}


