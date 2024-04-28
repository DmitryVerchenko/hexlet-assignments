package exercise;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int sortCount) {
        var resultList = new ArrayList<String>();
        List<Home> sortedList = new ArrayList<>(list);
        sortedList.sort(Home::compareTo);
        Collections.reverse(sortedList);
        for (Home home : sortedList) {
            resultList.add(home.toString());
        }
        return resultList.stream().limit(sortCount).toList();
    }
}

// END
