/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.jquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
public class SimpleQuizItem implements IQuizItem{

    private String leyend;
    private String urlImage;
    private int indexOfUserChoice;
    
    private List<ISelectableOption> options;
    private int indexAnswer;

    public SimpleQuizItem() {
        this.options = new ArrayList<>();
    }

    
    public String getLeyend() {
        return leyend;
    }

    public void setLeyend(String leyend) {
        this.leyend = leyend;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<ISelectableOption> getOptions() {
        return options;
    }

    public void setOptions(List<ISelectableOption> options) {
        this.options = options;
    }

    public int getIndexAnswer() {
        return indexAnswer;
    }

    public void setIndexAnswer(int indexAnswer) {
        this.indexAnswer = indexAnswer;
    }

    public int getIndexOfUserChoice() {
        return indexOfUserChoice;
    }

    public void setIndexOfUserChoice(int indexOfUserChoice) {
        this.indexOfUserChoice = indexOfUserChoice;
    }
    
    public void addOption(ISelectableOption option){
        if (this.options != null) {
            this.options.add(option);
        }
    }
    
    public static class SimpleQuizItemBuilder{
        private String leyend;
        private String urlImage;

        private List<ISelectableOption> options;
        private int indexAnswer;

        public SimpleQuizItemBuilder(String leyend, List<ISelectableOption> options, int indexAnswer) {
            this.leyend = leyend;
            this.options = options;
            this.indexAnswer = indexAnswer;
        }

        public SimpleQuizItemBuilder(String leyend,int indexAnswer) {
            this.leyend = leyend;
            this.indexAnswer = indexAnswer;
            this.options = new ArrayList<>();
        }
        
        public SimpleQuizItemBuilder urlImage(String urlImage){
            this.urlImage = urlImage;
            return this;
        }
        
        public SimpleQuizItemBuilder leyend(String leyend){
            this.leyend = leyend;
            return this;
        }
        
        public SimpleQuizItemBuilder correct(int indexOfCorrect){
            this.indexAnswer = indexOfCorrect;
            return this;
        }
        
        public SimpleQuizItemBuilder addItem(ISelectableOption item){
            this.options.add(item);
            return this;
        }
        
        public SimpleQuizItem build(){
            SimpleQuizItem result = new SimpleQuizItem();
            
            result.setIndexAnswer(indexAnswer);
            result.setIndexOfUserChoice(-1);
            result.setLeyend(leyend);
            result.setOptions(options);
            result.setUrlImage(urlImage);
            
            return result;
        }
    }
}
