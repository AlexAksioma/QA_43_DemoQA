package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaits {
    WebDriver driver = new ChromeDriver();
    @Test
    public void explicitWait(){
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        WebElement btnLogin = driver.findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        btnLogin.click();
        //pause(3);
        //WebElement inputEmail = driver.findElement(By.id("username"));
        //inputEmail.sendKeys("aksiomamedved@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")))
                .sendKeys("aksiomamedved@gmail.com");
        WebElement btnSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        btnSubmit.click();
        //By.cssSelector("data-testid="password"")
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[data-testid='password']"))))
                .sendKeys("AlexMed123!");
        driver.findElement(By.id("login-submit")).click();

        Assert.assertTrue(new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("alexmedved2/boards!!!")));

    }

    public void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
