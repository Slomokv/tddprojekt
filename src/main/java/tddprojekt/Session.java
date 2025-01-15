package tddprojekt;

import java.io.IOException;
import java.time.LocalDate;


public class Session {

    private double distance;
    private int time;
    private LocalDate date;

    public Session(double distance, int time, LocalDate date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    public Session(double distance, int time) {
        this.distance = distance;
        this.time = time;
        date = LocalDate.now();
    }
    

    public double getDistance(){
        return this.distance;
    }
    public int getTime(){
        return this.time;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
