package tddprojekt;

public class Calculator {

    public static double roundToOneDecimal(double value){
        double cleanValue = (double) (Math.round(value * 10.0))/10.0;
        return cleanValue;
    }
}
