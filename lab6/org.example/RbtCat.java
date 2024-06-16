package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RbtCat {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RbtCat(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goFrigePage(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/div/a[1]/span"));
        button.click();
    }
    public void FrigeButton(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div[5]/div[1]/div[2]/div[2]/a/span"));
        button.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void goLGPage(){
        WebElement LG = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div[4]/ul/li[4]/a/span"));
        LG.click();
    }

    public List<String> products(){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div[2]")));
        return product.stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
