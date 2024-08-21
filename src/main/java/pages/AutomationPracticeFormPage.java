package pages;

import dto.StudentDto;
import enums.Genders;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class AutomationPracticeFormPage extends BasePage {
    public AutomationPracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement inputMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;
    @FindBy(id = "currentAddress")
    WebElement textAreaCurrentAddress;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    //==============================================
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement textThanksFor;

    @FindBy(xpath = "//tbody/tr[2]/td[last()]")
    WebElement modalBodyEmail;

    public AutomationPracticeFormPage typeStudentForm(StudentDto student) {
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        typeFieldDateOfBirth(student.getDateOfBirth());
        typeFieldSubjects(student.getSubjects());
        typeFieldHobbies(student.getHobbies());
        textAreaCurrentAddress.sendKeys(student.getCurrentAddress());

        inputState.sendKeys(student.getState());
        inputState.sendKeys(Keys.ENTER);
        inputCity.sendKeys(student.getCity());
        inputCity.sendKeys(Keys.ENTER);

        return this;
    }

    public AutomationPracticeFormPage clickBtnSubmit(){
        btnSubmit.click();
        return this;
    }

    private void typeFieldHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeFieldSubjects(String subjects) {  //"Arts,Math,Biology,Chemistry"
        inputSubjects.click();
        String[] arraySplit = subjects.split(",");
        for (String str : arraySplit) {
            inputSubjects.sendKeys(str);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeFieldDateOfBirth(String dateOfBirth) { //18 Aug 2024
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS --> " + operationSystem);
        if (operationSystem.startsWith("Win"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a")); //windows
        else if (operationSystem.startsWith("Mac"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));  //mac
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void clickGender(Genders gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }

    public boolean isTextInElementPresent_textThanksFor(){
        return isTextInElementPresent(textThanksFor, "Thanks for submitting the form", 3);
    }
}
