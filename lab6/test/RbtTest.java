package test;

import org.example.RbtCat;
import org.example.RbtGeneral;
import org.example.RbtLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RbtTest {

    private WebDriver driver;
    private RbtGeneral rbtGeneral;

    private RbtLogin rbtLogin;
    private RbtCat rbtCat;

    @BeforeTest(groups = "All")
    public void prepare(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        rbtGeneral = new RbtGeneral(driver);
        rbtLogin = new RbtLogin(driver);
        rbtCat = new RbtCat(driver);
    }
    //1
    @Test(groups = "General")
    public void testRBTGeneral(){
        rbtGeneral.goTOHomePage();
        String title = rbtGeneral.getRBTTitle();
        System.out.println("Page title: "+ title);
        assert title.equals("RBT - интернет магазин недорогой бытовой техники и электроники");
    }

    //2
    @Test(groups = "General")
    public void testAbout(){
        rbtGeneral.goTOHomePage();
        String about = rbtGeneral.getAboutShop();
        System.out.println("About: " + about);
        assert about.contains("RBT.ru — интернет-магазин и сеть гипермаркетов бытовой техники и электроники с историей");
    }

    //3
    @Test(groups = "General")
    public void testSearchFunc(){
        rbtGeneral.goTOHomePage();
        rbtGeneral.searchFunc("водонагреватель");
        String result = rbtGeneral.getSearchresult();
        System.out.println("Search result: " + result);
        assert result.contains("ВОДОНАГРЕВАТЕЛИ");
    }

    //4
    @Test(groups = "General")
    public void testHelpMenu(){
        rbtGeneral.goTOHomePage();
        rbtGeneral.clickHelpMenu();
        List<String> helpmenuLinks = rbtGeneral.getHelpMenuLinks();
        System.out.println("Help menu links: " + helpmenuLinks);
        assert helpmenuLinks.contains("Магазины");
    }

    //5
    @Test(groups = "General")
    public void testHelpMlinkText(){
        rbtGeneral.goTOHomePage();
        rbtGeneral.clickHelpMenu();
        String shops = rbtGeneral.ShopsLink();
        System.out.println(shops);
        assert shops.equals("Магазины");

    }

    //6
    @Test(groups = "General")
    public void testHelpMlinkTap(){
        rbtGeneral.goTOHomePage();
        rbtGeneral.clickHelpMenu();
        rbtGeneral.clickHelpActions();
        String action = rbtGeneral.actions();
        System.out.println("Search result: " + action);
        assert action.equals("Специальные предложения");

    }

    //7
    @Test(groups = "Login")
    public void testLoginPage(){
        rbtGeneral.goTOHomePage();
        rbtGeneral.clickLoginPage();
        String title = rbtLogin.getLogRBTTitle();
        System.out.println("Page title: "+ title);
        assert title.equals("Вход в личный кабинет");
    }

    //8
    @Test(groups = "Login")
    public void testRegAlredyUsePhone(){
        rbtLogin.goTOLogPage();
        rbtLogin.clickRegestration();
        rbtLogin.enterAlreadyusePhone("Secret))");
        String errormas = rbtLogin.errorMassageREG();
        System.out.println("Error massage: "+ errormas);
        assert errormas.equals("Номер уже зарегистрирован. Войдите в личный кабинет.");
    }

    //9
    @Test(groups = "Login")
    public void testRemoveLogChecks(){
        rbtLogin.goTOLogPage();
        rbtLogin.clickRegestration();
        rbtLogin.clickChecks();
        boolean check = rbtLogin.verifyChecks();
        System.out.println(check);
        assert check;

    }

    //10
    @Test(groups = "Login")
    public void testEnterPhone(){
        rbtLogin.goTOLogPage();
        rbtLogin.enterPhone("9223501095");
        boolean button = rbtLogin.goButton();
        String massage = null;
        if(button == true){
            massage = "Кнопка активна, регистрация возможна";
            System.out.println(massage);
        }
        assert massage.equals("Кнопка активна, регистрация возможна");
    }

    //11
    @Test(groups = "Cat")
    public void testFrige(){
        rbtGeneral.goTOHomePage();
        rbtCat.goFrigePage();
        rbtCat.FrigeButton();
        String massage = rbtCat.getTitle();
        System.out.println(massage);
        assert massage.equals("Холодильник GORENJE NRK 6192 AXL4 - купить в интернет-магазине RBT.ru. Цены, отзывы, характеристики и доставка в Челябинске");
    }

    //12
    @Test(groups = "Cat")
    public void testLGproducts(){
        rbtGeneral.goTOHomePage();
        rbtCat.goLGPage();
        List<String> lg = rbtCat.products();
        System.out.println("Products: " + lg);
        assert lg.contains("Телевизоры");

    }

    //13
    @Test(groups = "Login")
    public void testForgotPhone(){
        rbtLogin.goTOLogPage();
        String text = rbtLogin.forgotPhone();
        System.out.println("Massage: "+text);
        assert !text.isEmpty();

    }

    @AfterTest(groups = "All")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
