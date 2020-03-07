package sda.tasks.design.principles;

public class OutputWriter implements Writer {
    @Override
    public void write(Object data) {
        System.out.printf("Count is: %s", String.valueOf(data));
    }
}
