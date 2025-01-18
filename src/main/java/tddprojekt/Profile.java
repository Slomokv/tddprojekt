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
        this.setLogCount(intId);

        this.logBook.put(stringId, session);
        this.keyChain.add(stringId);
        this.setFScore(calcFScore(this.getLogBook(), this.getFScore()));

    }
    public void removeSession(String id){
        this.logBook.remove(id);
        this.keyChain.remove("" + (1 + this.getLogCount())); //iterera genom för att ta bort IDt
    }



    public int calcFScore(HashMap<String, Session> logBook, int currentFS){
        int logs = logBook.size();
        String lastId = this.getKeyChain().get(logs - 1);

        if (logs < 1) {
            return 0;
        }
        else if (logs < 2) {
            return Calculator.fScoreFormula(currentFS, logBook.get(lastId), 0);
        }
        else {
            LocalDate[] dates =lastSessions(logBook);
            int timeSince = Calculator.timeBetweenDays(dates[0], dates[1]);

            return Calculator.fScoreFormula(currentFS, logBook.get(lastId), timeSince);
        }
    }

    public LocalDate[] lastSessions(HashMap<String, Session> logBook){
        LocalDate[] dates = new LocalDate[2];
        int i = (1 - this.getKeyChain().size());
        for (int j = 0; j >= 1; j++) {
            dates[j] = logBook.get(this.getKeyChain().get(i-j)).getDate();
        }
        return dates;
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
