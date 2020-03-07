package sda.tasks.design.principles;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generator {
    public Map<Integer, Long> generateMap(List<Integer> items) {
//        HashMap<Integer, Integer> result = new HashMap<>();
//        for (Integer integer : items) {
//            Integer count = result.getOrDefault(integer, 0);
//            result.put(integer, count + 1);
//        }

//        return result;
        return items.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }
}
