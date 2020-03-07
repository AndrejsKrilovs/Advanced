package sda.tasks.design.principles;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Integer> readAndTransform() throws IOException;
}
