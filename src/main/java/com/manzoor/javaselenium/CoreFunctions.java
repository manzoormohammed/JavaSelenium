package com.manzoor.javaselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;


public class CoreFunctions {


    private static final String EXTRA_FILES_DIR = "C:\\extraFiles\\"; // place to store extra files like geckodriver.exe, awscreds.yaml
    private static final String AWS_CONSOLE_URL = "https://console.aws.amazon.com";
    private static final String AWS_CREDS_FILE = EXTRA_FILES_DIR + "awscreds.yaml"; // file format is user: abc --NEW LINE-- pass: yourpassword

    public static void goToUrl(String url) {

        // if user forgot to put it in then assume it is http://
        if (! url.startsWith("http"))
            url = "http://" + url;

        Driver.Instance.navigate().to(url);

    }

    public static void loginAwsConsole() {

        Yaml yaml = new Yaml();

        HashMap<String,Object> awsCreds = new HashMap<String,Object>();
        try {
            InputStream ios = new FileInputStream(new File(AWS_CREDS_FILE));

            // Parse the YAML file and return the output as a series of Maps and Lists
            awsCreds = (HashMap<String,Object>)yaml.load(ios);

        } catch (Exception e) {
            e.printStackTrace();
        }

        goToUrl(AWS_CONSOLE_URL);
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 10);
        By submitBtn = By.id("signInSubmit-input");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
        Driver.Instance.findElement(By.id("ap_email")).sendKeys(awsCreds.get("user").toString());
        Driver.Instance.findElement(By.id("ap_password")).sendKeys(awsCreds.get("pass").toString());
        Driver.Instance.findElement(submitBtn).click();
        assert Driver.Instance.findElement(By.id("nav-usernameMenu")).getText().startsWith("Manzoor");

    }

}
