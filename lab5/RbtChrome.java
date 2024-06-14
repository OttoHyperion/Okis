import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RbtChrome {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rbt.ru/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.getTitle().startsWith("RBT"));
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xRbt1, xRbt2;

        xRbt1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/a[1]/span"));
        xRbt1.click();

        xRbt2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/a[1]/span"));
        xRbt2.click();

        WebElement cssRbt1;

        cssRbt1 = driver.findElement(By.cssSelector("body > div.page-catalogue.overlay.wrap > div.page-catalogue__inner > div.page-catalogue__col-right.page-catalogue__col-right_narrow > div.item-catalogue-list.overlay > div.item-catalogue-list__items > div:nth-child(1) > div.item-catalogue__info.item-catalogue__info-big > div.item-catalogue__item-name > a > span"));
        cssRbt1.click();

        driver.quit();



    }
}
