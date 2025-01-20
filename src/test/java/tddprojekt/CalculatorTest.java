package tddprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CalculatorTest {


    Calculator calc = new Calculator();

    LocalDate dateOne = LocalDate.of(2025,1,13);
    LocalDate dateTwo = LocalDate.of(2025,1,14);
    LocalDate dateThree = LocalDate.of(2025,1,16);

    Session sessionOne = new Session(4.2, 23, dateOne);
    Session sessionTwo = new Session(4.7, 23, dateTwo);
    Session sessionThree = new Session(5.6, 25, dateThree);
    
    @Mock
    private Profile mcProfile;



    @BeforeEach
    public void mcProfileSetup() {
        mcProfile = mock(Profile.class);
    }
    
    @Test
    public void testRoundingToOne(){
        
        double answer = 5.3;
        double roundMePls = 5.3245321;
        double rounded = calc.roundToOneDecimal(roundMePls);

        assertEquals(answer, rounded);
    }

    @Test
    public void testFScore(){


    }

    @Test
    public void testDoubleCheckIfBelowZero() {
        
    }

    @Test
    public void testSessionToString() {


        String[] actualPrint = new String[2];
        sessionOne.setId("1");
        sessionTwo.setId("2");
        actualPrint[0] = calc.sessionToString(sessionOne);
        actualPrint[1] = calc.sessionToString(sessionTwo);


        String[] expectedPrint = new String[2];
        expectedPrint[0] =
        ("\nSession ID: " + "1" + 
        "\nDate: " + "2025-01-13" +
        "\nDistance: " + "4.2" + "km" + 
        "\nTime: " + "23" + " minutes" + 
        "\nAverage velocity: " + sessionOne.getKmph() + "km/h" +
        "\nMinutes per kilometer: " + sessionOne.getMinPerKm() + "minutes");

        expectedPrint[1] =
        ("\nSession ID: " + sessionTwo.getId() + 
        "\nDate: " + sessionTwo.getDate() +
        "\nDistance: " + sessionTwo.getDistance() + "km" + 
        "\nTime: " + sessionTwo.getTime() + " minutes" + 
        "\nAverage velocity: " + sessionTwo.getKmph() + "km/h" +
        "\nMinutes per kilometer: " + sessionTwo.getMinPerKm() + "minutes");

        assertEquals(expectedPrint[0], actualPrint[0]);
        assertEquals(expectedPrint[1], actualPrint[1]);
        assertFalse(expectedPrint[0] == actualPrint[1]);
    }
}
