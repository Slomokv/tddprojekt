package tddprojekt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    
    @Test
    public void testRoundingToOne(){
        
        double answer = 5.3;
        double roundMePls = 5.3245321;
        double rounded = Calculator.roundToOneDecimal(roundMePls);

        assertEquals(answer, rounded);
    }
}
