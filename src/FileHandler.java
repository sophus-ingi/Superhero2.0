import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class FileHandler {
    private File file = new File("superhero.txt");

    public void saveSuperheroes(ArrayList<Superhero> database) {
        try (PrintStream out = new PrintStream(new FileOutputStream(file, true))) {
            for (Superhero superhero : database) {
                out.println(superhero.getName());

            }

            System.out.println("Superheroes saved to 'superhero.txt'");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadSuperheroes(ArrayList<Superhero> database) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Superhero superhero = parseSuperhero(line);
                if (superhero != null) {
                    database.add(superhero);
                }
            }
            // Sort the superheroes by name (change the sorting criterion as needed)
            Collections.sort(database, Comparator.comparing(Superhero::getName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Superhero parseSuperhero(String line) {
        String[] values = line.split(";");
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

    public void saveSuperheroes(ArrayList<Superhero> database) {
        try (PrintStream out = new PrintStream(new FileOutputStream(file, true))) {
            for (Superhero superhero : database) {
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
    public void loadSuperheros(ArrayList<Superhero> database) {
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

                Superhero superhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
                database.add(superhero);
            }
        }
    }
}

     */
