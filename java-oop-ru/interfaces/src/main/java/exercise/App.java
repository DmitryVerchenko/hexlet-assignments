package exercise;


import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int sortCount) {
        var resultList = new ArrayList<String>();
        List<Home> sortedList = new ArrayList<>(list);
        sortedList.sort(Home::compareTo);
        for (Home home : sortedList.reversed()) {
            resultList.add(home.toString());
        }
        return resultList.stream().limit(sortCount).toList();
    }
}

// END
