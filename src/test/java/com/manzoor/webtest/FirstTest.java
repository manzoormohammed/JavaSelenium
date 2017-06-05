package com.manzoor.webtest;


import com.manzoor.javaselenium.CoreFunctions;
import org.junit.Test;


public class FirstTest extends SeleniumTest {

    @Test
    public void awsLoginTest(){

        CoreFunctions.loginAwsConsole();

    }
}
