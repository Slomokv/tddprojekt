package tddprojekt;

import java.time.LocalDate;



public class Calculator {

    public double roundToOneDecimal(double value){
        double cleanValue = (double) (Math.round(value * 10.0))/10.0;
        return cleanValue;
    }

    public int timeBetweenDays(LocalDate newDate, LocalDate oldDate){
        int newDays = newDate.getDayOfYear();
        int oldDays = oldDate.getDayOfYear();
        int newYear = newDate.getYear();
        int oldYear = oldDate.getYear();

        if (newYear > oldYear){
            newDays =+ (newYear + newDays);
        }
        return (newDays - oldDays);
    }

    public int fScoreFormula(int currentFS, Session session, int timeSince){
        int fScore = (int) Math.round(currentFS + (session.getDistance() + session.getKmph()/session.getMinPerKm()) - (timeSince/2));
        if (fScore < 0) {
            fScore = 0;
        }
        return fScore;
    }

    public double[] doubleCheckIfBelowZero(double lowerLimit, double upperLimit) {
    double[] limits = new double[2];
    limits[0] = lowerLimit;
    limits[1] = upperLimit;
        if (lowerLimit < 0) {
            limits[0] = 0;
        }
        if (upperLimit < 0) {
            limits[1] = 0;
        }
    return limits;
    }

    public double[] doubleCheckIfLower(double[] limits) {
        if (limits[1] < limits[0]) {
            double temp = limits[1];
            limits[1] = limits[0];
            limits[0] = temp;
        }
        return limits;
    }

    public int[] intCheckIfBelowZero(int lowerLimit, int upperLimit) {
        int[] limits = new int[2];
        limits[0] = lowerLimit;
        limits[1] = upperLimit;
            if (lowerLimit < 0) {
                limits[0] = 0;
            }
            if (upperLimit < 0) {
                limits[1] = 0;
            }
        return limits;
    }

    public int[] intCheckIfLower(int[] limits) {
        if (limits[1] < limits[0]) {
            int temp = limits[1];
            limits[1] = limits[0];
            limits[0] = temp;
        }
        return limits;
    }

    public String sessionToString(Session session) {
        String stringToReturn = ("\nSession ID: " + session.getId() + 
                                "\nDate: " + session.getDate() +
                                "\nDistance: " + session.getDistance() + "km" + 
                                "\nTime: " + session.getTime() + " minutes" + 
                                "\nAverage velocity: " + session.getKmph() + "km/h" +
                                "\nMinutes per kilometer: " + session.getMinPerKm() + "minutes");
        return stringToReturn;
    }

}
