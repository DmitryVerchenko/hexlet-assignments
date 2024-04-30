package exercise;

import java.util.Map;
import java.util.List;

import static exercise.SingleTag.attributesToString;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> children;

    @Override
    public String toString() {
        return "<" + tagName + attributesToString(attributes) + ">" + tagBody + childrenListToString(children) + "</" + tagName + ">";
    }

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = children;

    }

    private String childrenListToString(List<Tag> children) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tag child : children) {
            stringBuilder.append(child);
        }
        return stringBuilder.toString();
    }
}

// END
