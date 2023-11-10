package fh;

import supDatCon.Superhero;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class FileHandlerOri {
    private File file = new File("superhero.txt");
    public final String DELIMITER = ",";

    public void saveSuperheroes(ArrayList<Superhero> superheroes) {
        try (PrintStream out = new PrintStream((file))) {
            for (Superhero superhero : superheroes) {
                out.println(superhero.getName() +","+ superhero.getRealName() +","+ superhero.getSuperPower() +","+ superhero.getYearCreated() +","+ superhero.isHuman() +","+ superhero.getStrength());


            }

            System.out.println("Superheroes saved to 'superhero.txt'");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Superhero> loadSuperheroes() {
        ArrayList<Superhero> superheroes = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Superhero superhero = parseSuperhero(line);
                if (superhero != null) {
                    superheroes.add(superhero);
                }
            }

            Collections.sort(superheroes, Comparator.comparing(Superhero::getName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return superheroes;
    }

    private Superhero parseSuperhero(String line) {
        String[] values = line.split(DELIMITER);
        if (values.length == 6) {
            String name = values[0];
            String realName = values[1];
            String superPower = values[2];
            int yearCreated = Integer.parseInt(values[3]);
            boolean isHuman = Boolean.parseBoolean(values[4]);
            int strength = Integer.parseInt(values[5]);
            return new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        }
        return null;
    }
}


/*public class FileHandler {
    private File file = new File("superhero.txt");

    public void saveSuperheroes(ArrayList<supDatCon.Superhero> database) {
        try (PrintStream out = new PrintStream(new FileOutputStream(file, true))) {
            for (supDatCon.Superhero superhero : database) {
                out.println(superhero.getName());
            }
            System.out.println("Superheroes saved to 'superhero.txt'");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

*/
    /*
    public void loadSuperheros(ArrayList<supDatCon.Superhero> database) {
        Scanner scanner = null;
        scanner = new Scanner("superhero.txt");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(";");
            if (values.length == 6) {
                String name = values[0];
                String realName = values[1];
                String superPower = values[2];
                int yearCreated = Integer.parseInt(values[3]);
                boolean isHuman = Boolean.parseBoolean(values[4]);
                int strength = Integer.parseInt(values[5]);

                supDatCon.Superhero superhero = new supDatCon.Superhero(name, realName, superPower, yearCreated, isHuman, strength);
                database.add(superhero);
            }
        }
    }
}

     */
