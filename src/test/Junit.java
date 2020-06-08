package test;

import controller.MainController;
import javafx.collections.ObservableList;
import library.Register;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class Junit {

    public MainController controller;


    @Before
    public void setUp() {
        controller = new MainController();
    }

    @Test
    public void register_inserted(){
        ObservableList<Register> list= controller.getRegistersList();
        //controller.insert(1,"eliz","Yilmaz","computer","ello@gmail.com", "12-01-2018","15.06.2020");
        Assert.assertEquals(0,list.size());
    }


    @After
    public void tearDown() {
        controller = null;
    }
}






