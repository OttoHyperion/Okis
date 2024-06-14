import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class edgeTestng {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testng.org/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.getTitle().startsWith("Test"));

        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> TableOfContents;
        TableOfContents = driver.findElements(By.xpath("//li/a"));
        for (int i = 0; i < TableOfContents.size(); i++) {
            System.out.println(TableOfContents.get(i).getAttribute("text"));
        }
        WebElement xTestng1;
        xTestng1 = driver.findElement(By.xpath("//*[@id=\"tocbot\"]/ul/li[2]/a"));
        xTestng1.click();

        WebElement cssTestng1;
        cssTestng1 = driver.findElement(By.cssSelector("a[href=\"#_testng_documentation\"]"));
        cssTestng1.click();


        driver.quit();


    }
}
