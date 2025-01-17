package tddprojekt;

import java.util.ArrayList;
import java.util.HashMap;

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
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.fitnessScore = 0;
    }


    public void addSession(Session session){
        this.setLogCount(this.getLogCount() + 1);
        this.logBook.put(("" + (1 + this.getLogCount())), session);

        this.setFScore(calcFScore(this.logBook), this.getFScore());

    }
    public void removeSession(String id){
        HashMap<String, Session> newLogBook = this.getLogBook();
        ArrayList<String> newKeyChain = this.getKeyChain();

        newLogBook.remove(id);
        this.keyChain.remove("" + (1 + this.getLogCount())); //iterera genom för att ta bort IDt

        this.setKeyChain(newKeyChain);
        this.setLogBook(newLogBook);
    }



    public int calcFScore(HashMap<String, Session> logBook, int currentFS){
        int id = logBook.size();

        if (logBook.size() < 1) {
            return 0;
        }
        else if (logBook.size() < 2) {
            return fScoreFormula(currentFS, logBook.get(id), 0);
        }
        else {
            //int timeSince = days since last run
            return fScoreFormula(currentFS, logBook.get(id), timeSince);
        }
        //formel CS + (distance + (kmph/minPerKm) - (t/2);
    }
    public int fScoreFormula(int currentFS, Session session, int timeSince){
        return (currentFS + (
    }



    //-------Get&Set-------

    public HashMap<String, Session> getLogBook(){
        return this.logBook;
    }
    public void setLogBook(HashMap<String, Session> logBook){
        this.logBook = logBook;
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
    public void setKeyChain(ArrayList<String> keyChain){
        this.keyChain = keyChain;
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
