package tddprojekt;

import java.time.LocalDate;


public class Session {

    private double distance;
    private int time;
    private LocalDate date;
    private double kmph;
    private double minPerKm;
    private String id;

    public Session(double distance, int time, LocalDate date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
        this.kmph = calcKmph(distance, time);
        this.minPerKm = calcMinPerKm(distance, time);
        this.id = "";
    }

    public Session(double distance, int time) {
        this(distance, time, (LocalDate.now()));

    }


    //-------Getters-------

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
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }



    //-------Calculator-------

    public double calcKmph(double distance, int time){
        Calculator calc = new Calculator();
        double hours = time/60.0;
        double kmph = distance/hours;
        return calc.roundToOneDecimal(kmph);
    }
    public double calcMinPerKm(double distance, int time){
        Calculator calc = new Calculator();
        double minPerKm = time/distance;
        return calc.roundToOneDecimal(minPerKm);
    }

}
