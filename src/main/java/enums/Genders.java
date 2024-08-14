package enums;

public enum Genders {  //for="gender-radio-1"
    MALE("//label[@for='gender-radio-1']"),
    FEMALE("//label[@for='gender-radio-2']"),
    OTHER("//label[@for='gender-radio-3']");

    private final String locator;
    Genders(String locator) {
        this.locator = locator;
    }
    public String getLocator(){
        return locator;
    }

}
