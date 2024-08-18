package tests;

import dto.StudentDto;
import enums.Genders;
import enums.Hobbies;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends ApplicationManager {
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
                .build();
        new HomePage(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .typeStudentForm(student)
                ;
    }
}
