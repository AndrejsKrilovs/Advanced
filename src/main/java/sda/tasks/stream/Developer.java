package sda.tasks.stream;

import sda.tasks.stream.objects.Adenine;
import sda.tasks.stream.objects.Cytosine;
import sda.tasks.stream.objects.Guanine;
import sda.tasks.stream.objects.Nucleoside;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * USE Stream API only!
 */
public class Developer {


    /**
     * Return List only with objects, that getACRTbase = "AC+"
     */
    public List<Nucleoside> findAllACRTBaseAc(List<Nucleoside> nucleosides) {
        return nucleosides.stream()
                .filter(item -> "AC+".equalsIgnoreCase(item.getACRTbase()))
                .collect(Collectors.toList());
    }


    /**
     * Add "A" to each element in list, and return updated list
     */
    public List<String> addAtoEachString(List<String> strings) {
        return strings.stream()
                .map(item -> String.format("%sA", item))
                .collect(Collectors.toList());
    }


    /**
     * Return Objects that are Adenine or Cytosine (in input list) with wight > 10
     */
    public List<Nucleoside> findAllAdenineCytosine(List<Nucleoside> nucleosides) {
        final Stream<Nucleoside> guanine = nucleosides.stream()
                .filter(item -> item instanceof Guanine);
        final Stream<Nucleoside> adenine = nucleosides.stream()
                .filter(item -> item instanceof Adenine);

        return Stream.concat(guanine, adenine)
                .filter(item -> item.getWight() > 10)
                .collect(Collectors.toList());
    }


    /**
     * Return List only with Guanine that getACRTbase = "2" (in input list)
     * Remember you can use .getClass of t or you can cast to (Something) t
     */
    public List<Guanine> findAllGuanineWithAcrtBase2(List<Nucleoside> nucleosides) {
        return nucleosides.stream()
                .filter(item -> item instanceof Guanine)
                .filter(item -> "2".equalsIgnoreCase(item.getACRTbase()))
                .map(item -> (Guanine)item)
                .collect(Collectors.toList());
    }


    /**
     * Extract all ACRTBase from list of Nucleoside and return
     */
    public List<String> getAllACRTBasesFromListDistinct(List<Nucleoside> nucleosides) {
        return nucleosides.stream()
                .map(Nucleoside::getACRTbase)
                .distinct()
                .collect(Collectors.toList());
    }


}

