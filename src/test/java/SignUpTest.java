import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest {

    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // Opened Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void zipCode(){
        /*
        Steps
        1. Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py
        3. Вводим 5 цифр, например 12345
        4. Нажать Continue
        5. Проверить, что кнопка Register видна
        6. Закрыть браузер
         */

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("12345"); //

        driver.findElement(By.cssSelector("[value = Continue]")).click();

        boolean inDisplay = driver.findElement(By.cssSelector("[value = Register]")).isDisplayed();
        assertTrue(inDisplay,"ERROR");

    }

    @Test
    public void zipCode1(){

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("1234"); //

        driver.findElement(By.cssSelector("[value = Continue]")).click();

        driver.findElement(By.xpath("//span[@class='error_message']")).getText();

    }

    @Test
    public void zipCode2(){

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("123456"); //

        driver.findElement(By.cssSelector("[value = Continue]")).click();

        driver.findElement(By.xpath("//span[@class='error_message']")).getText();


    }

    @AfterMethod(alwaysRun = true)

    public void tearDown(){
        driver.quit();
    }


}
