package tddprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

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
    public void testDoubleCheckIfBelowZero() {
        double[] actual1 = calc.doubleCheckIfBelowZero(-1.1, -0.5);
        double[] actual2 = calc.doubleCheckIfBelowZero(1.1, -0.5);
        double[] actual3 = calc.doubleCheckIfBelowZero(1.1, 0.5);

        assertEquals(0, actual1[0]);
        assertEquals(0, actual1[1]);
        assertEquals(1.1, actual2[0]);
        assertEquals(0, actual2[1]);
        assertEquals(1.1, actual3[0]);
        assertEquals(0.5, actual3[1]);
    }

    @Test
    public void testIntCheckIfBelowZero() {
        int[] actual1 = calc.intCheckIfBelowZero(-1, -5);
        int[] actual2 = calc.intCheckIfBelowZero(-2, 5);
        int[] actual3 = calc.intCheckIfBelowZero(3, 4);

        assertEquals(0, actual1[0]);
        assertEquals(0, actual1[1]);
        assertEquals(0, actual2[0]);
        assertEquals(5, actual2[1]);
        assertEquals(3, actual3[0]);
        assertEquals(4, actual3[1]);
    }

    @Test
    public void testIntCheckIfLower(){
        int[] testBase1 = new int[2];
        int[] testBase2 = new int[2];

        testBase1[0] = 2;
        testBase1[1] = 4;
        testBase2[0] = 4;
        testBase2[1] = 3;

        int[] expected1 = new int[2];
        int[] expected2 = new int[2];

        expected1[0] = 2;
        expected1[1] = 4;
        expected2[0] = 3;
        expected2[1] = 4;

        int[] actual1 = calc.intCheckIfLower(testBase1);
        int[] actual2 = calc.intCheckIfLower(testBase2);

        assertEquals(expected1[0], actual1[0]);
        assertEquals(expected1[1], actual1[1]);
        assertEquals(expected2[0], actual2[0]);
        assertEquals(expected2[1], actual2[1]);
    }

    @Test
    public void testDoubleCheckIfLower(){
        double[] testBase1 = new double[2];
        double[] testBase2 = new double[2];

        testBase1[0] = 2.2;
        testBase1[1] = 4.1;
        testBase2[0] = 4.3;
        testBase2[1] = 3.5;

        double[] expected1 = new double[2];
        double[] expected2 = new double[2];

        expected1[0] = 2.2;
        expected1[1] = 4.1;
        expected2[0] = 3.5;
        expected2[1] = 4.3;

        double[] actual1 = calc.doubleCheckIfLower(testBase1);
        double[] actual2 = calc.doubleCheckIfLower(testBase2);

        assertEquals(expected1[0], actual1[0]);
        assertEquals(expected1[1], actual1[1]);
        assertEquals(expected2[0], actual2[0]);
        assertEquals(expected2[1], actual2[1]);
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
