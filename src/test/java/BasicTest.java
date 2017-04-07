/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.jquiz.IQuizItem;
import com.core.jquiz.Quiz;
import com.core.jquiz.OneSelectableOption;
import com.core.jquiz.SimpleQuizItem;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gonza
 */
public class BasicTest {
    
    public BasicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void creatingTest() throws InterruptedException {
         int numberOfCorrects = 1;
         
         List<IQuizItem> items = new ArrayList<>();
         IQuizItem item1 = new SimpleQuizItem();
         IQuizItem item2 = new SimpleQuizItem();
         
         item1.setLeyend("Cuanto es 6 + 7");
         item1.setIndexAnswer(2);
         item1.addOption(new OneSelectableOption("2"));
         item1.addOption(new OneSelectableOption("1"));
         item1.addOption(new OneSelectableOption("13"));
         
         item2.setLeyend("Como se llama la capital de Chile");
         item2.setIndexAnswer(3);
         item2.addOption(new OneSelectableOption("Buenos Aires"));
         item2.addOption(new OneSelectableOption("Quito"));
         item2.addOption(new OneSelectableOption("Brasilia"));
         item2.addOption(new OneSelectableOption("Santiago"));
         
         items.add(item1);
         items.add(item2);
         
         Quiz q = new Quiz(items,60);
         q.passWith(numberOfCorrects);
         q.response(0, 1);
         q.response(1, 3);
         
         q.start();
         
         for (int i = 0; i < 10; i++) {
             
             System.out.println("Falta: " + q.remainTime());
             
             Thread.sleep(10000);
         }
         
         System.out.println("Score: " + q.score());
     }
}
