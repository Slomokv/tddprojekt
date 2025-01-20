package tddprojekt;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculatorTest {
    
    @Mock
    private Profile mcProfile;
    
    @Test
    public void testRoundingToOne(){
        
        double answer = 5.3;
        double roundMePls = 5.3245321;
        double rounded = Calculator.roundToOneDecimal(roundMePls);

        assertEquals(answer, rounded);
    }

    @Test
    public void testFScore(){

    mcProfile = mock(Profile.class);
    }

}
