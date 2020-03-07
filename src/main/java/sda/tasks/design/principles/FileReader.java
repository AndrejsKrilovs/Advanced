package sda.tasks.design.principles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader implements Reader {
    private UserInput input;

    public FileReader(UserInput input) {
        this.input = input;
    }

    @Override
    public List<Integer> readAndTransform() throws IOException {
        Path path = Paths.get(input.getString());
        return Files.readAllLines(path)
                .stream()
                .flatMapToInt(CharSequence::chars)
                .boxed()
                .collect(Collectors.toList());
    }
}
