package tddprojekt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ProfileTest {
    
    @BeforeEach
    public void profileTestValues(){

    int height = 167;
    double weight = 77.3;
    int age = 25;
    Profile testUser = new Profile(height, weight, age);
}

    @Test
    public void testProfileCreation(){

        assertEquals(height, testUser.getHeight());
        assertEquals(weight, testUser.getWeight());
        assertEquals(age, testUser.getAge());
    }

    @Test
    public void testLogExists(){

        boolean logbookEmpty = (0 == testUser.getLogbook().size());
        assertTrue(logbookEmpty);
    }

    @Test
    public void testLogSize(){

        Session session = new Session(4.2, 15);
        testUser.addSession(session)
                .addSession(session)
                .addSession(session);
        int logbookSize = testuser.getLogbook().size();
        boolean logbookNonEmpty = (0 != logbookSize);

        assertTrue(logbookNonEmpty);
        assertEquals(3, logbookSize);
    }
}