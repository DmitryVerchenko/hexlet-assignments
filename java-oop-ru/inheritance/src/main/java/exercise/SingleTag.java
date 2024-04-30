package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public static void main(String[] args) {
        Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        System.out.println(img.toString()); // <img class="v-10" id="wop">
    }
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        return "<" + tagName + attributesToString(attributes) + ">";
    }

    public static String attributesToString(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            stringBuilder.append(" ").append(pair.getKey()).append("=\"").append(pair.getValue()).append("\"");
        }
        return stringBuilder.toString();
    }
}

// END
