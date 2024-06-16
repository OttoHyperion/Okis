package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RbtGeneral {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RbtGeneral(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goTOHomePage(){
        driver.get("https://www.rbt.ru/");
    }

    public String getRBTTitle(){
        return driver.getTitle();
    }

    public String getAboutShop(){
        WebElement about = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[1]/h1")));
        return about.getText();
    }

    public String getSearchresult(){
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div[1]/h1")));
        String text = result.getText();
        return text;

    }

    public void searchFunc(String request){
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/input")));
        search.sendKeys(request);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[2]/button")));
        button.click();
    }

    public void clickHelpMenu(){
        WebElement helpmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/ul/li[3]/a")));
        helpmenu.click();
    }

    public List<String> getHelpMenuLinks(){
        List<WebElement> helpmenulist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[1]/div/ul/li[3]/ul")));
        return helpmenulist.stream().map(WebElement::getText).collect(Collectors.toList());

    }

    public String ShopsLink(){
        WebElement shops = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[3]/ul/li[3]/a/span"));
        String text = shops.getText();
        return text;
    }

    public void clickHelpActions(){
        WebElement actions = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[3]/ul/li[1]/a/span"));
        actions.click();
    }

    public String actions(){
        WebElement action = driver.findElement(By.xpath("/html/body/div[2]/div[2]/span"));
        String text = action.getText();
        return text;
    }

    public void clickLoginPage(){
        WebElement actions = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/a"));
        actions.click();
    }



}
