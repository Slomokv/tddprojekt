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

        if (this.logBook.containsKey(key)) {
            for (int i = 0; i < this.getKeyChain().size(); i++) {
                if (this.getKeyChain().get(i) == key) {
                    this.getLogBook().remove(key);
                    this.getKeyChain().remove(i);

                    this.calcFScore(this.getLogBook(), this.getKeyChain(), this.getFScore());
                    break;
                }
            }
        }
        else {
                System.out.println("Sorry, but the ID could not be found in your Logbook.");     
        }  
    }

    public void calcFScore(HashMap<String, Session> logBook, ArrayList<String> keyChain, int currentFS){
        int logs = logBook.size();

        if (logs < 1) {
            this.setFScore(0);
        }
        else if (logs == 1) {
            String lastId = keyChain.get(logs - 1);
            this.setFScore(Calculator.fScoreFormula(currentFS, logBook.get(lastId), 0));
        }
        else {
            String lastId = keyChain.get(logs - 1);
            LocalDate[] dates = lastSessions(keyChain);
            int timeSince = Calculator.timeBetweenDays(dates[0], dates[1]);

            this.setFScore(Calculator.fScoreFormula(currentFS, logBook.get(lastId), timeSince));
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
