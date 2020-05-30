package com.romanceabroad.ui;

import org.testng.annotations.DataProvider;

import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.readAllLines;

public class DataProviders {


    @DataProvider(name = "Registration")
    public static Object[][] testRegistration() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        readAllLines(Paths.get("Registration.csv")).stream().forEach(s -> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2() {
        return new Object[][]{
                {Data.email1, Data.nickname, true},
                {Data.email2, Data.nickname, false}, //negative test -> add assertion, if false passed
                {Data.email3, Data.nickname, true},
        };
    }

    //For invalid password
    @DataProvider(name = "Registration3")
    public static Object[][] testRegistration3() {
        return new Object[][]{
                {Data.email4, Data.nickname, false},  // email -> 1
        };
    }

    //For existingUser
    @DataProvider(name = "Registration4")
    public static Object[][] testRegistration4() {
        return new Object[][]{
                {Data.emailExistingUser, Data.nickname, false},  // email - exist
        };
    }

    //For invalidPassword
    @DataProvider(name = "Registration5")
    public static Object[][] testRegistration5() {
        return new Object[][]{
                {Data.email3, Data.passwordInvalid, false},  // pwd: "12", req-ts 6 characters
        };
    }

    @DataProvider(name = "ContactUs")
    public static Object[][] testContactUs() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        readAllLines(Paths.get("ContactUs.csv")).stream().forEach(s -> {

            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "Gifts")
    public static Object[][] testGiftsRegularList() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        readAllLines(Paths.get("Gifts.csv")).stream().forEach(s -> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "PrettyWomen")
    public static Object[][] testPrettyWomenFeature() {
        return new Object[][]{
                {"18", "80", "Default"},
                {"18", "19", "Name"},
                {"30", "40", "Views"},
                {"60", "80", "Registration date"},
        };
    }

}
