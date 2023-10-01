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

    Map<String, String> cities = new HashMap<>() {{
        put("NCR", RandomUtils.getRandomArrayValue(ncrCity));
        put("Uttar Pradesh", RandomUtils.getRandomArrayValue(uttarPradeshCity));
        put("Haryana", RandomUtils.getRandomArrayValue(haryanaCity));
        put("Rajasthan", RandomUtils.getRandomArrayValue(rajasthanCity));
    }};
    public final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public final String TEXT_BOX_URL = "/text-box";
    public final String USER_NAME = faker.name().firstName();
    public final String USER_SURNAME = faker.name().lastName();
    public final String USER_EMAIL = faker.internet().emailAddress();
    public final String USER_GENDER = RandomUtils.getRandomArrayValue(gender);
    public final String USER_NUMBER = faker.phoneNumber().subscriberNumber(10);
    public final Date BIRTHDAY = faker.date().birthday();
    public final String YEAR_OF_BIRTH = RandomUtils.getValueFromDate("y", BIRTHDAY);
    public final String MONTH_OF_BIRTH = RandomUtils.getValueFromDate("MMMM", BIRTHDAY);
    public final String DAY_OF_BIRTH = RandomUtils.getValueFromDate("dd", BIRTHDAY);
    public final String SUBJECT = RandomUtils.getRandomArrayValue(subjects);
    public final String HOBBY = RandomUtils.getRandomArrayValue(hobbies);
    public final String FILE_NAME = "vsFile.png";
    public final String USER_STATE = RandomUtils.getRandomArrayValue(state);
    public final String USER_CITY = cities.get(USER_STATE);
    public final String CURRENT_ADDRESS = faker.address().streetAddress();
    public final String PERMANENT_ADDRESS = faker.address().streetAddress();
    public final String TEST_TEXT = faker.lorem().characters(10);
    public final String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";
}
