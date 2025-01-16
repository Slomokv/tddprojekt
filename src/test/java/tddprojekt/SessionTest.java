package tddprojekt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class SessionTest {

    
    @Test 
    public void testCreate() {
        LocalDate date = LocalDate.of(1993,9,01);
        LocalDate today = LocalDate.now();
        Session aSession = new Session(5.3, 15, date);
        Session bSession = new Session(6.2, 16);


        assertEquals(5.3, aSession.getDistance());
        assertEquals(15, aSession.getTime());
        assertEquals(21.2, aSession.getKmph());
        assertEquals(2.8, aSession.getMinPerKm());
        assertEquals(date, aSession.getDate());

        assertEquals(6.2, bSession.getDistance());
        assertEquals(16, bSession.getTime());
        assertEquals(23.0, bSession.getKmph());
        assertEquals(2.6, bSession.getMinPerKm());
        assertEquals(today, bSession.getDate());
    
    }
}
