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
    public String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public String TEXT_BOX_URL = "/text-box";
    public String USER_NAME = faker.name().firstName();
    public String USER_SURNAME = faker.name().lastName();
    public String USER_EMAIL = faker.internet().emailAddress();
    public String USER_GENDER = RandomUtils.getRandomArrayValue(gender);
    public String USER_NUMBER = faker.phoneNumber().subscriberNumber(10);
    public Date BIRTHDAY = faker.date().birthday();
    public String YEAR_OF_BIRTH = RandomUtils.getValueFromDate("y", BIRTHDAY);
    public String MONTH_OF_BIRTH = RandomUtils.getValueFromDate("MMMM", BIRTHDAY);
    public String DAY_OF_BIRTH = RandomUtils.getValueFromDate("dd", BIRTHDAY);
    public String SUBJECT = RandomUtils.getRandomArrayValue(subjects);
    public String HOBBY = RandomUtils.getRandomArrayValue(hobbies);
    public String FILE_NAME = "vsFile.png";
    public String USER_STATE = RandomUtils.getRandomArrayValue(state);
    public String USER_CITY = statesAndCities.get(USER_STATE);
    public String CURRENT_ADDRESS = faker.address().streetAddress();
    public String PERMANENT_ADDRESS = faker.address().streetAddress();
    public String TEST_TEXT = faker.lorem().characters(10);
    public String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";
}
