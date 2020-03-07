package sda.tasks.exceptions.and.optional.and.collection;

import java.util.*;

public class Junior {

    /**
     *  return new List, you will have a lot of operation to insert elements in middle of list. Think what implementation you should use
     *  write in comments what is difference between List implementations and what list there are
     */
    public List createList(){
        return new LinkedList<>();
    }

    /**
     *  return List created from Array (contains same elements)
     */
    public List<String> arrayToList(String[] arr){
        return Arrays.asList(arr);
    }

    /**
     *  get element in provided index, and add 5 to it and return
     */
    public Integer getElementFromPositionAndAdd5ToIt(List<Integer> list, int index){
        final Integer value = list.get(index);
        return value + 5;
    }

    /**
     * create Set with 3 any String elements
     */
    public Set<String> createSetWith3AnyElements(){
        final Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            resultSet.add(String.valueOf(i));
        }
        return resultSet;
    }

    /**
     * return HashMap where key:String and value:Integer, Put at least one key value inside;
     */
    public Object createHashMapStringIntеger(){
        final HashMap<String, Integer> resultHashMap = new HashMap<>();
        resultHashMap.put("1", 1);
        return resultHashMap;
    }

}
