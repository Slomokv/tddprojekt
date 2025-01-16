package tddprojekt;

import java.util.HashMap;

public class Profile {
    private HashMap<String, Session> logBook;
    private int logCount;
    private double height;
    private double weight;
    private int age;
    private int fitnessScore;

    public Profile(double height, double weight, int age) {
        this.logBook = new HashMap<String, Session>();
        this.logCount = logBook.size();
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.fitnessScore = 0;
    }

    public void addSession(Session session){
        this.setFScore(this.fitnessScore + calcFScore(this.logBook, newSession));
        this.setLogCount(this.getLogCount() + 1);
        this.logBook.put("S" + this.getLogCount(), session);
    }
    public int calcFScore(HashMap<String, Session> logBook, Session session){
        if (logBook.size() < 1) {
            
        }
        //formel CS + (distance + (kmph/minPerKm) - (t/2);
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
