package tddprojekt;

import java.io.IOException;
import java.time.LocalDate;
import java.math.*;


public class Session {

    private double distance;
    private int time;
    private LocalDate date;
    private double kmph;
    private double minPerKm;

    public Session(double distance, int time, LocalDate date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
        this.kmph = calcKmph(distance, time);
        this.minPerKm = calcMinPerKm(distance, time);
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
    public double getKmph(){
        return this.kmph;
    }
    public double getMinPerKm(){
        return this.minPerKm;
    }



    //-------Calculator-------

    public double calcKmph(double distance, int time){
        double hours = time/60.0;
        double kmph = distance/hours;
        return roundToOneDecimal(kmph);
    }
    public double calcMinPerKm(double distance, int time){
        double minPerKm = time/distance;
        return roundToOneDecimal(minPerKm);
    }
    public double roundToOneDecimal(double value){
        double cleanValue = (double) (Math.round(value * 10.0))/10.0;
        return cleanValue;
    }
}
