package com.manzoor.webtest;


import com.manzoor.javaselenium.Driver;
import org.junit.After;
import org.junit.Before;


public class SeleniumTest {

    @Before
    public void initializeDriver() {

        Driver.initialize();

    }

    @After
    public void cleanUp() {

        Driver.close();

    }

}
