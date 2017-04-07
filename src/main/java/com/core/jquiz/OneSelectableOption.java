/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.jquiz;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
public class OneSelectableOption implements ISelectableOption{

    private String option;
    
    @Override
    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String getOption() {
        return option;
    }

    public OneSelectableOption(String option) {
        this.option = option;
    }
}
