package tddprojekt;

import java.time.LocalDate;



public class Calculator {

    public static double roundToOneDecimal(double value){
        double cleanValue = (double) (Math.round(value * 10.0))/10.0;
        return cleanValue;
    }

    public static int timeBetweenDays(LocalDate newDate, LocalDate oldDate){
        int newDays = newDate.getDayOfYear();
        int oldDays = oldDate.getDayOfYear();
        int newYear = newDate.getYear();
        int oldYear = oldDate.getYear();

        if (newYear > oldYear){
            newDays =+ (newYear + newDays);
        }
        return (newDays - oldDays);
    }

    public static int fScoreFormula(int currentFS, Session session, int timeSince){
        return (int) Math.round(currentFS + (session.getDistance() + session.getKmph()/session.getMinPerKm()) - (timeSince/2));
    }
}
