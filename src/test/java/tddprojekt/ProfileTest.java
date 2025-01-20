package tddprojekt;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;

public class ProfileTest {
    


    int height = 167;
    double weight = 77.3;
    int age = 25;
    Profile testUser = new Profile(height, weight, age);
    Session testSession = new Session(4.2, 41);




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
    public void testAddAndRemoveSession(){

        LocalDate dateOne = LocalDate.of(2025,1,13);
        LocalDate dateTwo = LocalDate.of(2025,1,14);
        LocalDate dateThree = LocalDate.of(2025,1,16);

        Session sessionOne = new Session(4.2, 23, dateOne);
        Session sessionTwo = new Session(4.7, 23, dateTwo);
        Session sessionThree = new Session(5.6, 25, dateThree);


        //-------addSession()-------

        testUser.calcFScore(testUser.getLogBook(), testUser.getKeyChain(), testUser.getFScore());
        int initScore = testUser.getFScore();

        testUser.addSession(sessionOne);
        int fstScore = testUser.getFScore();
        assertEquals(1, testUser.getLogBook().size());
        assertEquals(1, testUser.getKeyChain().size());

        testUser.addSession(sessionTwo);
        int sndScore = testUser.getFScore();
        assertEquals(2, testUser.getLogBook().size());
        assertEquals(2, testUser.getKeyChain().size());

        testUser.addSession(sessionThree);
        int trdScore = testUser.getFScore();
        assertEquals(3, testUser.getLogBook().size());
        assertEquals(3, testUser.getKeyChain().size());

        assertEquals(3, testUser.getLogCount());
        assertTrue(testUser.getLogCount() == testUser.getLogBook().size());

        //-------removeSession()-------


        testUser.removeSession(1);
        int removedFst = testUser.getFScore();
        assertEquals(2, testUser.getKeyChain().size());
        assertEquals(2, testUser.getLogBook().size());

        testUser.removeSession(1); //checking for non-existent key
        assertEquals(2, testUser.getKeyChain().size());
        assertEquals(2, testUser.getLogBook().size());


        testUser.removeSession(2);
        int removedSnd = testUser.getFScore();
        assertEquals(1, testUser.getLogBook().size());
        assertEquals(1, testUser.getKeyChain().size());

        testUser.removeSession(3);
        int removedTrd = testUser.getFScore();
        assertEquals(0, testUser.getLogBook().size());
        assertEquals(0, testUser.getKeyChain().size());

        assertEquals(3, testUser.getLogCount());
        assertFalse(testUser.getLogCount() == testUser.getLogBook().size());


        //-------calcFScore()-------

        assertEquals(0, initScore);
        assertTrue(fstScore != initScore);
        assertTrue(sndScore != fstScore);
        assertTrue(trdScore != sndScore);
        assertTrue(removedFst != trdScore);
        assertTrue(removedSnd != removedFst);
        assertEquals(0, removedTrd);
    }



    LocalDate dateOne = LocalDate.of(2024,12,13);
    LocalDate dateTwo = LocalDate.of(2025,1,7);
    LocalDate dateThree = LocalDate.of(2025,1,16);

    ArrayList<Session> sessionList = new ArrayList<>();
    Session sessionOne = new Session(4.2, 23, dateOne);
    Session sessionTwo = new Session(4.7, 23, dateTwo);
    Session sessionThree = new Session(5.6, 25, dateThree);


    @Test
    public void testTotalDistance() {
        assertEquals(0, testUser.totalDistance());
        
        testUser.addSession(sessionOne);
        testUser.addSession(sessionTwo);
        testUser.addSession(sessionThree);

        assertEquals(14.5, testUser.totalDistance());
    }

    @Test
    public void testAverageKmph() {
        testUser.addSession(sessionOne);
        testUser.addSession(sessionTwo);
        testUser.addSession(sessionThree);
        double avgKmph = testUser.avgKmph();
        assertEquals(12.2, avgKmph);
    }

    @Test
    public void testFilter() {

    }

}