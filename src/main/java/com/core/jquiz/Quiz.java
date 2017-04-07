/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.jquiz;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
public class Quiz {

    private List<IQuizItem> items;
    private int numberOfCorrects;
    
    private int minutesToTest;
    private DateTime begin;
    private DateTime end;
    private DateTime current;
    private Thread time;

    public Quiz(List<IQuizItem> items, int minutesToTest) {
        this.items = items;
        this.minutesToTest = minutesToTest;
    }

    public Quiz(List<IQuizItem> items, int numberOfCorrects, int minutesToTest) {
        this.items = items;
        this.numberOfCorrects = numberOfCorrects;
        this.minutesToTest = minutesToTest;
    }
    
    public List<IQuizItem> getItems() {
        return items;
    }

    public int getMinutesToTest() {
        return minutesToTest;
    }

    public void setMinutesToTest(int minutesToTest) {
        this.minutesToTest = minutesToTest;
    }

    public void setItems(List<IQuizItem> items) {
        this.items = items;
    }
    
    
    public void passWith(int numberOfCorrects){
        this.numberOfCorrects = numberOfCorrects;
    }
    
    public void start(){
        this.begin = new DateTime();
        this.end = new DateTime().plusMinutes(minutesToTest);
        
        time = new Thread(() -> {
            current = new DateTime();
            while(end.getMillis() - current.getMillis() > 0){
                current = new DateTime();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt();
                }
            }
        });
        time.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public long remainMillis(){
        long result = -1;
        if (begin != null && end != null && current != null) {
            result = end.getMillis() - current.getMillis();
        }
        return result;
    }
    
    public String remainTime(){
        String result = "";
        long millis = remainMillis();
        if (millis > -1) {
            result = String.format("%d min, %d sec", 
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) - 
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
            );
        }
        return result;
    }
    
    public boolean finish(){
        return corrects() > numberOfCorrects;
    }
    
    private int corrects(){
        int count = (int)items.stream().filter(item -> item.getIndexAnswer() == item.getIndexOfUserChoice()).count();
        return count;
    }
    
    public double score(){
        return numberOfCorrects > 0 && items.size() > 0 ? corrects() /  (double)items.size() : 0;
    }
    
    public void response(int indexOfItem, int indexOfChoice){
        if (indexOfItem >= 0 && indexOfItem < items.size() && indexOfChoice >= 0 && indexOfChoice < items.get(indexOfItem).getOptions().size()) {
            this.items.get(indexOfItem).setIndexOfUserChoice(indexOfChoice);
        }
    }
}
