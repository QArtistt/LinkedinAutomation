import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class WriteMessagetoRecruiters {

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void signin(){
        driver.get("https://www.linkedin.com/?trk=seo-authwall-base_nav-header-logo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("session_key")));
        driver.findElement(By.id("session_key")).sendKeys("qamerdur@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("ebosi123");
        driver.findElement(By.cssSelector(".sign-in-form__submit-btn--full-width")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder='Search']")));
        driver.findElement(By.cssSelector("[placeholder='Search']")).click();
        driver.findElement(By.cssSelector("[placeholder='Search']")).sendKeys("it recruiter");
        driver.findElement(By.cssSelector("[placeholder='Search']")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Add a location']")));
        driver.findElement(By.xpath("//span[normalize-space()='Add a location']")).click();


        driver.findElement(By.xpath("//span[normalize-space()='Add a location']")).sendKeys("Germany");
        driver.findElement(By.xpath("//li[6]//fieldset[1]//div[1]//ul[1]//li[1]")).click();



    }


    @AfterEach
    void tearDown(){
        driver.close();
    }




}
