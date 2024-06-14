import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AnimegoChrome {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://animego.org/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.getTitle().startsWith("Смотреть"));
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = driver.findElements(By.xpath("//*[@id=\"wrap\"]/div[3]/div/div/div/div"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xAnimego1, xAimego2;

        xAnimego1 = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div/ul[1]/li[2]/a"));
        xAnimego1.click();

        xAimego2 = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div/ul[1]/li[3]/a"));
        xAimego2.click();

        WebElement cssAnimego1;

        cssAnimego1 = driver.findElement(By.cssSelector("a[href=\"https://animego.org/anime\""));
        cssAnimego1.click();

        driver.quit();

    }
}
