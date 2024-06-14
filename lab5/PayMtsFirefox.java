import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayMtsFirefox {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://payment.mts.ru/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.getTitle().startsWith("МТС"));
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = driver.findElements(By.xpath("//*[@id=\"b-unauth-landing_payment\"]/div/div/div[1]/div/div[3]"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xPayMTS1, xPayMTS2;

        xPayMTS1 = driver.findElement(By.xpath("//*[@id=\"b-unauth-landing_payment\"]/div/div/div[1]/div/div[3]/div[1]/div/a/div[2]"));
        xPayMTS1.click();

        xPayMTS2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/section[3]/div/div/div[2]/a/div/div[2]"));
        xPayMTS2.click();

        WebElement cssPayMTS1;

        cssPayMTS1 = driver.findElement(By.cssSelector(".mts16-mainmenu__lv1-link"));
        cssPayMTS1.click();

        driver.quit();
    }
}
