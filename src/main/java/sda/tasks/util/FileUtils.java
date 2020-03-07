package sda.tasks.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    private final static String PATH_VARIABLE = "./src/main/resources/data-file.txt";
    private final static String ESCAPE_CHARACTER = "e";

    public static void main(String[] args)  {
        final StringBuilder content = new StringBuilder();

        try(final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!ESCAPE_CHARACTER.equalsIgnoreCase(bufferedReader.readLine())) {
                content.append(System.currentTimeMillis() % 2);
            }
        } catch (IOException ieo) {
            System.err.printf("Cannot read data form keyboard\n%s", ieo.getCause());
        }

        try {
            Files.write(
                    Paths.get(PATH_VARIABLE),
                    String.valueOf(content)
                            .getBytes(StandardCharsets.UTF_8)
            );
        } catch (IOException ieo) {
            System.err.printf("Cannot write file %s\n%s", PATH_VARIABLE, ieo.getCause());
        }

        try {
            Files.readAllLines(
                    Paths.get(PATH_VARIABLE),
                    StandardCharsets.UTF_8
            ).forEach(System.out::println);
        } catch (IOException ieo) {
            System.err.printf("Cannot read file %s\n%s", PATH_VARIABLE, ieo.getCause());
        }
    }
}
