package tddprojekt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class AthleteTest {
    
    @BeforeEach
    public void userTestValues(){

    int height = 167;
    double weight = 77.3;
    int age = 25;
    Athlete testUser = new Athlete(height, weight, age);

    }

    @Test
    public void testAthleteCreate(){

        assertEquals(height, testUser.getHeight());
        assertEquals(weight, testUser.getWeight());
        assertEquals(age, testUser.getAge());
    }

    @Test
    public void testAthleteLogbook(){

        assertEquals(0,(testUser.getLogbook().size()));
        

    }
}