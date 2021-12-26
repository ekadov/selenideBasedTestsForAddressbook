package ru.addressbook.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateData {

    public static final Faker faker = new Faker();

    public static String generateFirstName() {
        return (faker.name().firstName());
    }

    public static String generateLastName() {
        return (faker.name().lastName());
    }

    public static String generateNickName() {
        return (faker.name().username());
    }

    public static String generateCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }


}
