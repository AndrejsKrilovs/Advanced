package sda.tasks.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Junior {

    /**
     * Create stream with String elements "A", "B", "C"
     */
    public Stream<String> createStream(){
        return Stream.of("A", "B", "C");
    }

    /**
     * Returns List from Stream
     */
    public List<Integer> collectList(Stream<Integer> stream){
        return stream.collect(Collectors.toList());
    }

    /**
     * return first Element from Stream
     */
    public String needFirst(Stream<String> stream){
        return stream.findFirst().orElseThrow(RuntimeException::new);
    }

    /**
     * return element quantity in stream
     */
    public Long howMany(Stream<String> stream){
        return stream.count();
    }

    /**
     * return stream from list
     */
    public Stream<String> streamFromList(List<String> list){
        return list.stream();
    }

}
