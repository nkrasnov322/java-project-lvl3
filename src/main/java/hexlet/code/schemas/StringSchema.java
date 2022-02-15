package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public void required() {
        addPredicate((x) -> (x != null && !((String) x).isEmpty()));
    }

    public void minLength(int length) {
        addPredicate((x) -> (x != null && ((String) x).length() >= length));
    }

    public void contains(String str) {
        addPredicate((x) -> (x != null && ((String) x).contains(str)));
    }

}
