package sda.tasks.stream;

import sda.tasks.stream.objects.DNA;
import sda.tasks.stream.objects.Nucleoside;

import java.util.*;
import java.util.stream.Collectors;

/**
 * USE Stream API only
 */
public class Senior {

    /**
     * you have a list with nucleoside lists. That all should be set as list of nucleoside in DNA Object
     * (add all from all lists)
     */
    public DNA createDnaFromListOfNucleoside(List<List<Nucleoside>> nucleosides) {
        final List<Nucleoside> nucleosideList = nucleosides.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        final DNA result = new DNA();
        result.setNucleosides(nucleosideList);
        return result;
    }


    /**
     * Get all ACRTbase From all Guanine from all DNA (extract all Guanine from all chain of nucleoside)
     * it can be Null.. not need to extract and add Null
     */
    public List<String> extractAllACRTbaseFromAllDnaIfExists(List<DNA> dnas) {
        return dnas.stream()
                .flatMap(item -> item.getNucleosides().stream())
                .map(Nucleoside::getACRTbase)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * You have DNA with list with Nucleoside, you need return 4 lists with different Nucleoside
     * 1 List = List<Adenine>
     * 2 List = List<Cytosine>
     * 3 List = List<Guanine>
     * 3 List = List<Thymine>
     */
    public List<List<Nucleoside>> extractAllNucleosideFromDNA(DNA dna) {

        final Map<String, List<Nucleoside>> unsortedMap = dna.getNucleosides().stream()
                .collect(Collectors.groupingBy(item -> item.getClass().getName()));

        final Map<String, List<Nucleoside>> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        return new ArrayList<>(sortedMap.values());
    }

    /**
     * you have a list of maps where is String key, and List with strings as value
     * you need to find a longest string in that list and replace value in that map with it
     * return replaced structure
     */
    public List<Map<String, String>> replaceEachValueInMapWithLongestStringInList(
            List<Map<String, List<String>>> maps) {
        return maps.stream()
                .map(this::longestString)
                .collect(Collectors.toList());
    }

    private Map<String, String> longestString(final Map<String, List<String>> item) {
        return item.entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        entity -> entity.getValue()
                                .stream()
                                .max(Comparator.comparing(String::length))
                                .orElseThrow(RuntimeException::new)
                )
        );
    }

    /**
     * return ACRTbase as KEY and Wight as Integer in MAP
     * If there are same ACRTBase replace it with oldValue_1 (+"_1") (+"_2") e.t.c
     * THAT ONE BADLY HARD
     */
    public Map<String, Integer> getAllACRTbaseAndWightAsMap(DNA dna) {
        return dna.getNucleosides().stream().collect(
                Collectors.toMap(
                        item -> String.format("%s_%d", item.getACRTbase(), dna.getNucleosides().indexOf(item)),
                        Nucleoside::getWight
                ));
    }
}
