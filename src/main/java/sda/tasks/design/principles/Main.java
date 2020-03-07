package sda.tasks.design.principles;

import java.io.IOException;

public class Main {
    private static void showData(Generator generator, Reader reader, Writer writer) throws IOException {
        Object value = generator.generateMap(reader.readAndTransform());
        writer.write(value);
    }

    public static void main(String[] args) throws IOException {
        /* ./src/main/resources/data-file.txt */
        showData(new Generator(), new FileReader(new UserInputImpl()), new OutputWriter());
    }
}
