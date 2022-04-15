package education.cccp.mobile.room;

import static java.util.Locale.getDefault;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import education.cccp.mobile.room.model.User;

public class Data {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy", getDefault());
    private static List<User> users;

    static {
        users = new ArrayList<>();
        try {
            users.add(new User(
                    1L,
                    "jdoe",
                    "john.doe@acme.com",
                    "John",
                    "Doe",
                    formatter.parse("10/02/2021"),
                    "password"));

            users.add(new User(
                    2L,
                    "jdoe",
                    "jane.doe@acme.com",
                    "Jane",
                    "Doe",
                    formatter.parse("10/02/2020"),
                    "password"));
            users.add(new User(
                    3L,
                    "jbloggs",
                    "joe.bloggs@acme.com",
                    "Joe",
                    "Bloggs",
                    formatter.parse("10/02/2019"),
                    "password"));
            users.add(new User(
                    4L,
                    "jschmoe",
                    "joe.schmoe@acme.com",
                    "Joe",
                    "Schmoe",
                    formatter.parse("10/02/2018"),
                    "password"));
            users.add(new User(
                    5L,
                    "dharry",
                    "dick.harry@acme.com",
                    "Dick",
                    "Harry",
                    formatter.parse("10/02/2017"),
                    "password"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<User> findAll() {
        return users;
    }
}