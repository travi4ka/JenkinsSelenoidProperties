package testData;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    public static String
            nameFirst = faker.name().firstName(),
            nameLast = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phone = String.valueOf(faker.number().numberBetween(1000000000L, 9999999999L)),
            subject = faker.options().option("Maths", "Arts"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            pictureName = "ws_Hidden_Sun_&_Wheat_Field_640x960.jpg",
            currentAddress = faker.address().fullAddress(),
            birthDateYear = String.valueOf(faker.number().numberBetween(1970, 1990)),
            birthDateMonth = faker.options().option("October", "December", "July"),
            birthDateDay = String.valueOf(faker.number().numberBetween(1, 28)),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana"),
            city = getRandomCity(state);

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) return faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh")) return faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana")) return faker.options().option("Karnal", "Panipat");
        return "";
    }
}
