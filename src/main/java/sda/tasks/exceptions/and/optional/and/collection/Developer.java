package sda.tasks.exceptions.and.optional.and.collection;


import java.util.*;

public class Developer {

    /**
     * Add element to List by provided value and then reverse list
     */
    public void addElementToPositionAndReverse(List<Integer> list, int index, Integer element) {
        list.add(index, element);
        Collections.reverse(list);
    }

    public String getKeyWithBiggestIntegerValue(HashMap<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;

        for (final Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        assert maxEntry != null;
        return maxEntry.getKey();
    }

    public List<String> getListOfElementsThatAreSameForBothLists(List<String> list1, List<String> list2) {
        final List<String> resultList = new ArrayList<>();

        for(final String item: list1) {
            if(list2.contains(item)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    /**
     * Create HashMap with key value. from List where there is a strings in format [Key]:[value]
     * List<String> first element D3:55 will create a record in hashmap with key D3 and value 55
     */
    public Map<String, Integer> createHashMapFromList(List<String> list) {
        final Map<String, Integer> resultMap = new HashMap<>();

        for (final String item: list) {
            final String[] strings = item.split(":");
            resultMap.put(strings[0], Integer.valueOf(strings[1]));
        }

        return resultMap;
    }

    /**
     * create a MAP that will keep order of elements, and add 3 elements to it
     * Write in comments what is difference between MAP implementations, what map`s exists
     */
    public Map<String, Integer> createMapThatWillKeepOrderOfElementsAndAdd3Element() {
        final Map<String, Integer> resultMap = new LinkedHashMap<>();
        for(int i = 0; i < 3; i++) {
            resultMap.put(String.valueOf(i), i);
        }
        return resultMap;
    }
}
