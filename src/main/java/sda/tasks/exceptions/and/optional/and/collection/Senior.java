package sda.tasks.exceptions.and.optional.and.collection;


import java.util.*;

public class Senior {

    /**
     *  return HashMap where Key:String = word and Integer amount of words in List<String> words
     */
    public Map<String, Integer> hashMapWithElementsCount(List<String> words){
        final Map<String, Integer> result = new HashMap<>();

        for (final String letter : words) {
            final Integer elementCount = Collections.frequency(words, letter);
            result.put(letter, elementCount);
        }

        return result;
    }



    /**
     * Delete elements with provided positions. (lets think position starts from 1)
     * WHY LinkedHashMap is used ?
     */
    public void updateHashMapDeleteElements(LinkedHashMap<String, String> map, List<Integer> positionToDelete) {
        final List<Map.Entry<String, String>> items = new LinkedList<>(map.entrySet());

        for (final Integer index : positionToDelete) {
            final Map.Entry<String, String> value = items.get(index-1);
            map.remove(value.getKey());
        }
    }

    /**
     *  first element list will contain one "A1"
     *  scond element list will contains two "A1","A2"
     *  third element list will contains "A1","A2","A3"
     *  repeat until n
     */
    public List<List<String>> listOfTheLists(int n){
        final List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            final List<String> subList = new ArrayList<>();

            for (int j = 1; j <= i; j++) {
                subList.add(String.format("A%d", j));
            }

            result.add(subList);
        }

        return result;
    }


    /**
     *  return List that will contains all elements of type clazz (provided) from the param list
     */
    public List<Object> createList(List<?> list, Class clazz){
        final List<Object> result = new ArrayList<>();

        for(final Object item : list) {
            if(item.getClass().equals(clazz)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Input map (List<String>> map): - for each Key that starts from letter
     * A create a map key will be 0..1..2..3..4..5 and value will be longest element from the List
     * return list of create maps
     */
    public List<Map<String, String>> returnListOfMaps(Map<String, List<String>> map){
        final List<Map<String, String>> result = new ArrayList<>();

        for(final Map.Entry<String, List<String>> item : map.entrySet()) {
            if(item.getKey().contains("A")) {
                result.add(longestString(item.getValue()));
            }
        }

        Collections.reverse(result);
        return result;
    }

    private Map<String, String> longestString(final List<String> items) {
        final Map<String, String> result = new HashMap<>();
        String longestString = "";

        for(final String item : items) {
            if(item.length() > longestString.length()) {
                result.put(String.valueOf(items.indexOf(item)), item);
            }
        }
        return result;
    }

}
