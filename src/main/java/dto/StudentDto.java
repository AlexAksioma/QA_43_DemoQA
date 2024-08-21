package dto;

import enums.Genders;
import enums.Hobbies;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString

public class StudentDto {
    private String name;
    private String lastName;
    private String email;
    private Genders gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private List<Hobbies> hobbies;
    private String currentAddress;
    private String state;
    private String city;
}
