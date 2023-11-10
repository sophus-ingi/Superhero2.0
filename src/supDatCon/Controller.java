package supDatCon;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;

public class Controller {
    private Database db;
   // private FileHandlerOri fh;



    public Controller(Database db) {
        this.db = db;
        //this.fh = fh;
    }

    public ArrayList<Superhero> findAllSuperhero(String search) {
        return db.findAllSuperhero(search);

    }


    public Superhero findSuperhero(String search) {
        return db.findSuperhero(search);
    }

    public ArrayList<Superhero> getDatabase() {

        return db.getSuperheroes();
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        db.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
    }

    public void sortSuperheroes(String sortBy) {
        ArrayList<Superhero> superheroes = db.getSuperheroes();
        System.out.println(superheroes);
        switch (sortBy.toLowerCase()) {
            case "name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getName));
                System.out.println("List has been sorted!");
                break;
            case "real name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getRealName));
                System.out.println("List has been sorted!");
                break;
            case "superpower":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getSuperPower));
                System.out.println("List has been sorted!");
                break;
            case "year created":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getYearCreated));
                System.out.println("List has been sorted!");
                break;
            //case "is human":
                //Collections.sort(superheroes, Comparator.comparing(Superhero::getIshuman);
               // break;
            case "strength":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getStrength));
                System.out.println("List has been sorted!");
                break;
            case "strength and real name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getStrength).thenComparing(Superhero::getRealName).reversed());
                System.out.println("List has been sorted!");
                break;
            case "Year created and name":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getYearCreated).thenComparing(Superhero::getName).reversed());
                System.out.println("List has been sorted!");
                break;
            case "Superpower and strength":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getSuperPower).thenComparing(Superhero::getStrength).reversed());
                System.out.println("List has been sorted!");
                break;
            default:
                System.out.println("Invalid sorting attribute");
                return;

        }
        System.out.println(superheroes);
        db.setSuperheroes(superheroes);

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

    public void editSuperheroDetails(){ //TODO make edit work

    }
    public ArrayList<Superhero> loadSuperheroes(){
        return db.loadSuperheroes();
    }

    public void save(){
        db.save();
    }
}


