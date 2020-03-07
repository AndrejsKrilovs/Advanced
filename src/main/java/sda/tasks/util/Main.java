package sda.tasks.util;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(11);
        user.setName("N");
        user.setSurname("S");

        UserService userService = new UserService();
        User newUser = userService.increaseAgeAndReturn(user);
        userService.getUserId(newUser.getAge())
                .ifPresent(System.out::println);
    }
}
