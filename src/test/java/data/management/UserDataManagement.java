package data.management;

import com.github.javafaker.Faker;

import java.util.UUID;

public class UserDataManagement {

    private static final UserDataManagement instance = new UserDataManagement();

    public static UserDataManagement getInstance() {
        return instance;
    }

    public String generateRandomUserEmail() {

        String domain = "example.com";
        String randomUUID = UUID.randomUUID().toString();
        String emailPrefix = randomUUID.replaceAll("-", "");
        return emailPrefix + "@" + domain;
    }

    public String generateRandomName() {

        Faker faker = new Faker();
        return faker.name().fullName();
    }

}
