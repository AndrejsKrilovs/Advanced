package sda.tasks.design.principles;

import java.util.Scanner;

public class UserInputImpl implements UserInput {
    @Override
    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
