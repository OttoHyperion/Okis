import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RanobeEdge {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://ranobelib.me/ru?section=home-updates");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.getTitle().startsWith("Читать"));
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[7]/div"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xRanobe1, xRanobe2;

        xRanobe1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/div[3]/div/a/span"));
        xRanobe1.click();

        xRanobe2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div/a[2]/span"));
        xRanobe2.click();

        WebElement cssRanobe1;

        cssRanobe1 = driver.findElement(By.cssSelector(".tabs-item__inner"));
        cssRanobe1.click();

        driver.quit();


    }
}
