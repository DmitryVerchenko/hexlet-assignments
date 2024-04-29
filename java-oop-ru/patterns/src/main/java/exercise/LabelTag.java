package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    public static void main(String[] args) {
        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
// <label>Press Submit<input type="submit" value="Save"></label>
    }
    String string;
    TagInterface tag;

    public LabelTag(String string, TagInterface tag) {
        this.string = string;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + string + tag.render() + "</label>";
    }
}

// END
