package exercise;

import java.util.*;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int sortCount) {
        var resultList = new ArrayList<String>();
        var sortedList = new ArrayList<>(list);
        sortedList.sort(Home::compareTo);
        for (Home home : sortedList.reversed()) {
            resultList.add(home.toString());
        }
        return resultList.stream().limit(sortCount).toList();
    }
}

// END
