package supDatCon;

import java.util.ArrayList;
import java.util.Collections;

import fh.FileHandlerOri;
import supDatCon.comp.*;


public class Database {
    private ArrayList<Superhero> superheroes;
    private FileHandlerOri fileHandler;

    public Database() {
        superheroes = new ArrayList<>();
        fileHandler = new FileHandlerOri();
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        Superhero superhero = new Superhero(superheroName, realName, superpower, creationYear, isHuman, strength);
        superheroes.add(superhero);
        fileHandler.saveSuperheroes(superheroes);
    }



    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> findAllSuperhero(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero s : superheroes) {
            if (s.getName().contains(search)) {
                searchResult.add(s);

            }

        }
        if (searchResult.isEmpty()) {
            return null;
        } else
            return searchResult;
    }

    public Superhero findSuperhero(String search) {
        for (Superhero s : superheroes) {
            if (s.getName().contains(search)) {
                return s;
            }
        }

        System.out.println("No superheroes in the list with that name");
        return null;
    }

    public void editSuperhero(Superhero s) {

    }

    public int size() {
        return superheroes.size();
    }

    public Superhero get(int index) {
        if (index >= 0 && index < superheroes.size()) {
            return superheroes.get(index);
        } else {
            return null;
        }
    }

    public void save(){
        fileHandler.saveSuperheroes(superheroes);

    }

    public void removeSuperhero(int index) {
        superheroes.remove(get(index));

    }

    public void setSuperheroes(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    public ArrayList<Superhero> loadSuperheroes() {
        superheroes = fileHandler.loadSuperheroes();
        return superheroes;
    }



    public void sortIsHuman(){
        System.out.println(" List is now sorted by is human");
        Collections.sort(superheroes, new IsHumanComp());
        System.out.println(superheroes);

    }
    public void sortRealName(){
        System.out.println(" List is now sorted by is real name");
        Collections.sort(superheroes, new RealNameComp());
        System.out.println(superheroes);

    }
    public void sortStrength(){
        System.out.println(" List is now sorted by is Strength");
        Collections.sort(superheroes, new StrengthComp());
        System.out.println(superheroes);

    }
    public void sortSuperPower(){
        System.out.println(" List is now sorted by Superpower");
        Collections.sort(superheroes, new SuperPowerComp());
        System.out.println(superheroes);

    }
    public void sortYearCreated(){
        System.out.println(" List is now sorted by is year created");
        Collections.sort(superheroes, new YearCreatedComp());
        System.out.println(superheroes);

    }
    public void sortSuperheroName(){
        System.out.println(" List is now sorted by is human");
        Collections.sort(superheroes, new SuperheroNameComp());
        System.out.println(superheroes);

    }
   /* public static void main(String[] args) throws FileNotFoundException {

        PrintStream addSuperhero = new PrintStream((""));
        System.setOut(addSuperhero);

        System.out.println("before");




        System.out.println("after");

    }*/


}
