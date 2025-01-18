package tddprojekt;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.HashMap;

public class ProfileTest {
    


    int height = 167;
    double weight = 77.3;
    int age = 25;
    Profile testUser = new Profile(height, weight, age);
    Session testSession = new Session(4.2, 41);

    @Mock
    private Profile mcProfile;


    @Test
    public void testProfileCreation(){


        assertEquals(height, testUser.getHeight());
        assertEquals(weight, testUser.getWeight());
        assertEquals(age, testUser.getAge());
    }

    @Test
    public void testLogExists(){

        boolean logBookEmpty = (0 == testUser.getLogBook().size());
        assertTrue(logBookEmpty);
    }

    @Test
    public void testLogSize(){

        for (int i = 1; i < 3; i++) {
            testUser.addSession(testSession);
        }
        
        int logBookSize = testUser.getLogBook().size();
        boolean logbookNonEmpty = (0 != logBookSize);

        assertTrue(logbookNonEmpty);
        assertEquals(testUser.getLogCount(), logBookSize);
    }


    @Test
    public void testAddSession(){


}

    @Test
    public void testFScore(){

        HashMap<String, Session> dummyMap = new HashMap<String, Session>();
        mcProfile = mock(Profile.class);

        when(mcProfile.calcFScore(dummyMap, 0)).thenReturn(19);
        
        assertEquals(19, mcProfile.calcFScore(dummyMap, 0));
        verify(mcProfile).calcFScore(dummyMap, 0);


        assertEquals(0, testUser.getFScore());

        LocalDate dateOne = LocalDate.of(2025,1,13);
        LocalDate dateTwo = LocalDate.of(2025,1,14);
        LocalDate dateThree = LocalDate.of(2025,1,16);

        Session sessionOne = new Session(4.2, 23, dateOne);
        Session sessionTwo = new Session(4.7, 23, dateTwo);
        Session sessionThree = new Session(5.6, 25, dateThree);

        testUser.addSession(sessionOne);
        int fstScore = testUser.getFScore();

        testUser.addSession(sessionTwo);
        int sndScore = testUser.getFScore();

        testUser.addSession(sessionThree);
        int trdScore = testUser.getFScore();

        assertTrue(fstScore != 0);
        assertTrue(sndScore != fstScore);
        assertTrue(trdScore != sndScore);

        
    }

}