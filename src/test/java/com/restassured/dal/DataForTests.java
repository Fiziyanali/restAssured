package com.restassured.dal;

import org.testng.annotations.DataProvider;

public class DataForTests {


    @DataProvider(name= "DataForPost")
    public Object[][] dataForPost(){
        /*
        Object[][] data = new Object[2][3]; //İki satır 3 sutun
        data[1][0] = "Albert";
        data[1][1] = "Einstein";
        data[1][2] = 2;

        data[0][0] = "Thomas";
        data[0][1] = "Edison";
        data[0][2] = 1;

        return data;
         */
        return  new Object[][] {
                {"Graham", "Bell", 1},
                {"Henry", "Ford", 2}
        };
    }

    @DataProvider(name="DeleteData")
    public Object[] dataForDelete(){
        return new Object[] {
                5,6
        };
    }
}
