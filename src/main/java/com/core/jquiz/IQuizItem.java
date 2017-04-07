/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.jquiz;

import java.util.List;

/**
 *
 * @author gonza
 */
public interface IQuizItem {
    
    public String getLeyend();

    public void setLeyend(String leyend);

    public String getUrlImage();

    public void setUrlImage(String urlImage);

    public List<ISelectableOption> getOptions();

    public void setOptions(List<ISelectableOption> options);

    public int getIndexAnswer();

    public void setIndexAnswer(int indexAnswer);

    public int getIndexOfUserChoice();

    public void setIndexOfUserChoice(int indexOfUserChoice);
    
    public void addOption(ISelectableOption option);
}
