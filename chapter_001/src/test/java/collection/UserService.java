package collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Anastasia", 0, calendar);
        User user2 = new User("Anastasia", 0, calendar);

        Map<User, Object> userMap = new HashMap<>();
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        System.out.println(userMap);
    }
}
