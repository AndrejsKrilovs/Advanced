package sda.tasks.util;

import java.util.Optional;

public class UserService {
    public User increaseAgeAndReturn(final User user) {
        user.setAge(user.getAge()+1);
        return user;
    }

    public Optional<User> getUserId(final int id) {
        if(id > 10) {
            User user = new User();
            user.setName("N");
            user.setSurname("S");
            user.setAge(11);

            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
