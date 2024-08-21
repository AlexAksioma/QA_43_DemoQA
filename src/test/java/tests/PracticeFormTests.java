package tests;

import dto.StudentDto;
import enums.Genders;
import enums.Hobbies;
import enums.StateCity;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORTS);
        StudentDto student = StudentDto.builder()
                .name("Frodo")
                .lastName("Baggins")
                .email("frodo_baggins@mail.com")
                .gender(Genders.MALE)
                .mobile("3332223322")
                .dateOfBirth("11 Sep 2000")
                .subjects("Arts,Math,Biology,Chemistry")
                .hobbies(hobbies)
                .currentAddress("Address st.1 app.123")
                .state(StateCity.RAJASTHAN.getState())
                .city(StateCity.RAJASTHAN.getCity()[1])
                .build();
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .typeStudentForm(student)
                .clickBtnSubmit()
                .isTextInElementPresent_textThanksFor())
                ;
    }
    @Test
    public void practiceFormPositiveTest_softAssert(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORTS);
        StudentDto student = StudentDto.builder()
                .name("Frodo")
                .lastName("Baggins")
                .email("frodo_baggins@mail.com")
                .gender(Genders.MALE)
                .mobile("3332223322")
                .dateOfBirth("11 Sep 2000")
                .subjects("Arts,Math,Biology,Chemistry")
                .hobbies(hobbies)
                .currentAddress("Address st.1 app.123")
                .state(StateCity.RAJASTHAN.getState())
                .city(StateCity.RAJASTHAN.getCity()[1])
                .build();
        new HomePage(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .typeStudentForm(student)
                .clickBtnSubmit()
                .isTextInElementPresent_textThanksFor()
                ;
        WebElement email = getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]"));
        softAssert.assertEquals(student.getName(), email.getText(),"assert email");
        System.out.println("========================================");

        WebElement mobile = getDriver().findElement(By.xpath("//tbody/tr[4]/td[last()]"));
        softAssert.assertEquals(student.getMobile(), mobile.getText(), "assert mobile");
        System.out.println("========================================");

        softAssert.assertAll();
    }
}
