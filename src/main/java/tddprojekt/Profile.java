package tddprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;


public class Profile {
    private HashMap<String, Session> logBook;
    private int logCount;
    private ArrayList<String> keyChain;
    private double height;
    private double weight;
    private int age;
    private int fitnessScore;

    public Profile(double height, double weight, int age) {
        this.logBook = new HashMap<String, Session>();
        this.logCount = 0;
        this.keyChain = new ArrayList<String>();
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.fitnessScore = 0;
    }


    public void addSession(Session session){
        int intId = this.getLogCount() + 1;
        String stringId = ("" + intId);
        this.getLogBook().put(stringId, session);
        this.getKeyChain().add(stringId);
        this.setLogCount(intId);

        this.calcFScore(this.getLogBook(), this.getKeyChain(), this.getFScore());
    }


    public void removeSession(int id){
        String key = ("" + id);
        Session fetchedSession = this.getLogBook().get(key);

        if (fetchedSession != null) {
            for (int i = 0; i < this.getKeyChain().size(); i++) {
                if (id == Integer.parseInt(this.getKeyChain().get(i))) {
                    this.getLogBook().remove(key);
                    this.getKeyChain().remove(i);
                    break;
                }
            }
            this.calcFScore(this.getLogBook(), this.getKeyChain(), this.getFScore());
        }
        else {
            System.out.println("Sorry, but the ID could not be found in your Logbook.");
        }
    }  
    

    public void calcFScore(HashMap<String, Session> logBook, ArrayList<String> keyChain, int currentFS){
        Calculator calc = new Calculator();
        int logs = logBook.size();

        if (logs < 1) {
            this.setFScore(0);
        }
        else if (logs == 1) {
            String lastId = keyChain.get(logs - 1);
            this.setFScore(calc.fScoreFormula(currentFS, logBook.get(lastId), 0));
        }
        else {
            String lastId = keyChain.get(logs - 1);
            LocalDate[] dates = lastSessions(keyChain);
            int timeSince = calc.timeBetweenDays(dates[0], dates[1]);

            this.setFScore(calc.fScoreFormula(currentFS, logBook.get(lastId), timeSince));
        }
    }


    public LocalDate[] lastSessions(ArrayList<String> keyChain){
        LocalDate[] dates = new LocalDate[2];
        int i = (keyChain.size() - 1);
        for (int j = 0; j < 2; j++) {
            dates[j] = this.getLogBook().get(keyChain.get(i-j)).getDate();
        }
        return dates;
    }

    
    public double totalDistance() {
        double totalDistance = 0;
        for (String s : this.getKeyChain()) {
            totalDistance = totalDistance + (this.getLogBook().get(s)).getDistance();
        }
        return totalDistance;
    }

    public double avgKmph() {
        Calculator calc = new Calculator();
        double avgKmph = 0;
        for (String s : this.getKeyChain()) {
            avgKmph = avgKmph + this.getLogBook().get(s).getKmph();
        }
        avgKmph = calc.roundToOneDecimal(avgKmph/this.getLogBook().size());
        return avgKmph;
    }

    public ArrayList<Session> filteredByDistance(double lowerLimit, double upperLimit) {
        Calculator calc = new Calculator();
        ArrayList<Session> filtered = new ArrayList<Session>();

        double[] limits = calc.doubleCheckIfBelowZero(lowerLimit, upperLimit);
        limits = calc.doubleCheckIfLower(limits);
        
        for (String s : this.getKeyChain()) {
            if ((limits[0] <= this.getLogBook().get(s).getDistance()) && (this.getLogBook().get(s).getDistance() <= limits[1])) {
                filtered.add(this.getLogBook().get(s));
            }
        }
        return filtered;
    }

    public ArrayList<Session> filteredByTime(int lowerLimit, int upperLimit) {
        Calculator calc = new Calculator();
        ArrayList<Session> filtered = new ArrayList<Session>();

        int[] limits = calc.intCheckIfBelowZero(lowerLimit, upperLimit);
        limits = calc.intCheckIfLower(limits);

        for (String s : this.getKeyChain()) {
            if ((limits[0] <= this.getLogBook().get(s).getTime()) && (this.getLogBook().get(s).getTime() <= limits[1])) {
                filtered.add(this.getLogBook().get(s));
            }
        }
        return filtered;
    }


    //-------Get&Set-------

    public HashMap<String, Session> getLogBook(){
        return this.logBook;
    }
    public int getLogCount(){
        return this.logCount;
    }
    public void setLogCount(int count){
        this.logCount = count;
    }
    public ArrayList<String> getKeyChain(){
        return this.keyChain;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public int getAge(){
        return this.age;
    }
    public int getFScore(){
        return this.fitnessScore;
    }
    public void setFScore(int score){
        this.fitnessScore = score;
    }



}
