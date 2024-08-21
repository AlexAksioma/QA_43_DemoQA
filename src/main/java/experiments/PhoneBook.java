package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneBook {
    static WebDriver driver;

    public static void main(String[] args) {

    }
    public static void clickContact(String phone){  // //h3[text()='1111111111']/..
        WebElement contact = driver.findElement(By.xpath("//h3[text()='"+phone+"']/.."));
        contact.click();
    }
}
