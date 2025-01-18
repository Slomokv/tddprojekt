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
        HashMap<String, Session> newLogBook = this.getLogBook();
        ArrayList<String> newKeyChain = this.getKeyChain();

        int intId = this.getLogCount() + 1;
        String stringId = ("" + intId);
        newLogBook.put(stringId, session);
        newKeyChain.add(stringId);

        this.setLogCount(intId);
        this.setLogBook(newLogBook);
        this.setKeyChain(newKeyChain);

        this.setFScore(calcFScore(newLogBook, newKeyChain, this.getFScore()));
    }

    public void removeSession(String id){
        this.logBook.remove(id);
        this.keyChain.remove("" + (1 + this.getLogCount())); //iterera genom för att ta bort IDt
    }



    public int calcFScore(HashMap<String, Session> logBook, ArrayList<String> keyChain, int currentFS){
        int logs = logBook.size();


        if (logs < 1) {
            return 0;
        }
        else if (logs == 1) {
            String lastId = keyChain.get(logs - 1);
            return Calculator.fScoreFormula(currentFS, logBook.get(lastId), 0);
        }
        else {
            String lastId = keyChain.get(logs - 1);
            LocalDate[] dates = lastSessions(logBook, keyChain);
            int timeSince = Calculator.timeBetweenDays(dates[0], dates[1]);

            return Calculator.fScoreFormula(currentFS, logBook.get(lastId), timeSince);
        }
    }

    public LocalDate[] lastSessions(HashMap<String, Session> logBook, ArrayList<String> keyChain){
        LocalDate[] dates = new LocalDate[2];
        int i = (keyChain.size() - 1);
        for (int j = 0; j < 2; j++) {
            dates[j] = logBook.get(keyChain.get(i-j)).getDate();
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
