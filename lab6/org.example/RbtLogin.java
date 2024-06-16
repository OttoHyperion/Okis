package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RbtLogin {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RbtLogin(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void goTOLogPage(){
        driver.get("https://www.rbt.ru/user/login/");
    }

    public String getLogRBTTitle(){
        return driver.getTitle();
    }

    public void clickRegestration(){
        WebElement clickreg = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[5]/a/span"));
        clickreg.click();
    }

    public void enterAlreadyusePhone(String phone){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/form[1]/div[1]/input")));
        passwordField.sendKeys(phone);
    }

    public String errorMassageREG(){
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/form[1]/div[1]/div/span/span/span[2]")));
        String text = error.getText();
        return text;
    }

    public void clickChecks(){
        WebElement check1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form[1]/div[4]/div[1]/span"));
        check1.click();
        WebElement check2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form[1]/div[4]/div[2]/span"));
        check2.click();
    }
    public boolean verifyChecks(){
        WebElement check1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form[1]/div[4]/div[1]/span"));
        WebElement check2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form[1]/div[4]/div[2]/span"));
        if(check1.isSelected() && check2.isSelected()){
            return false;
        } else {
            return true;
        }
    }

    public void enterPhone(String phone){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/form/div[1]/input")));
        passwordField.sendKeys(phone);
    }

    public boolean goButton(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[4]/button/span"));
        if(button.isEnabled()){
            return true;
        } else {
            return false;
        }
    }

    public String forgotPhone(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[4]/span/span[1]"));
        button.click();
        WebElement texts = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[4]/span/span[2]/span/span[2]"));
        String text = texts.getText();
        return  text;
    }


}
