package fh;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import supDatCon.Superhero;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerOriTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadSuperheroes() {

        FileHandlerOri fileHandler = new FileHandlerOri();
        ArrayList<Superhero> expectedSuperheroes = new ArrayList<>();
        expectedSuperheroes.add(new Superhero("Batman", "Bruce Wayne", "Rich", 1967, true, 99));
        expectedSuperheroes.add(new Superhero("Spiderman", "Peter Parker", "spider", 2000, true, 98));


        ArrayList<Superhero> loadedSuperheroes = fileHandler.loadSuperheroes();

        assertEquals(expectedSuperheroes.size(), loadedSuperheroes.size());
        for (int i = 0; i < expectedSuperheroes.size(); i++) {
            assertEquals(expectedSuperheroes.get(i).getName(), loadedSuperheroes.get(i).getName());
            assertEquals(expectedSuperheroes.get(i).getName(), loadedSuperheroes.get(i).getName());
            assertEquals(expectedSuperheroes.get(i).getRealName(), loadedSuperheroes.get(i).getRealName());
            assertEquals(expectedSuperheroes.get(i).getSuperPower(), loadedSuperheroes.get(i).getSuperPower());
            assertEquals(expectedSuperheroes.get(i).getYearCreated(), loadedSuperheroes.get(i).getYearCreated());
            assertEquals(expectedSuperheroes.get(i).isHuman(), loadedSuperheroes.get(i).isHuman());
            assertEquals(expectedSuperheroes.get(i).getStrength(), loadedSuperheroes.get(i).getStrength());
    }
}
}