package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestData {

    Faker faker = new Faker();
    public String[] gender = {"Male", "Female", "Other"},
            subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry",
                    "Computer Science", "Commerce", "Accounting", "Economics",
                    "Arts", "Social Studies", "History", "Civics"},
            hobbies = {"Sports", "Reading", "Music"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            ncrCity = {"Delhi", "Gurgaon", "Noida"},
            uttarPradeshCity = {"Agra", "Lucknow", "Merrut"},
            haryanaCity = {"Karnal", "Panipat"},
            rajasthanCity = {"Jaipur", "Jaiselmer"};

    Map<String, String> statesAndCities = new HashMap<>() {{
        put("NCR", RandomUtils.getRandomArrayValue(ncrCity));
        put("Uttar Pradesh", RandomUtils.getRandomArrayValue(uttarPradeshCity));
        put("Haryana", RandomUtils.getRandomArrayValue(haryanaCity));
        put("Rajasthan", RandomUtils.getRandomArrayValue(rajasthanCity));
    }};
    public String automationPracticeUrl = "/automation-practice-form";
    public String textBoxUrl = "/text-box";
    public String userName = faker.name().firstName();
    public String userSurname = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = RandomUtils.getRandomArrayValue(gender);
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public Date birthday = faker.date().birthday();
    public String yearOfBirth = RandomUtils.getValueFromDate("y", birthday);
    public String monthOfBirth = RandomUtils.getValueFromDate("MMMM", birthday);
    public String dayOfBirth = RandomUtils.getValueFromDate("dd", birthday);
    public String subject = RandomUtils.getRandomArrayValue(subjects);
    public String hobby = RandomUtils.getRandomArrayValue(hobbies);
    public String fileName = "vsFile.png";
    public String userState = RandomUtils.getRandomArrayValue(state);
    public String userCity = statesAndCities.get(userState);
    public String currentAddress = faker.address().streetAddress();
    public String permanentAddress = faker.address().streetAddress();
    public String testText = faker.lorem().characters(10);
    public String textInResultWindow = "Thanks for submitting the form";
}
