package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

    WebDriver driver;

    @Test
    public void locatorsCss(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        WebElement btn1 = driver.findElement(By.cssSelector("div[class='card mt-4 top-card']"));
        System.out.println(btn1.getAttribute("class"));
        WebElement h5 = driver.findElement(By.xpath("//*[text()='Elements']"));
        System.out.println(h5.getTagName());

        driver.quit();
    }
}
