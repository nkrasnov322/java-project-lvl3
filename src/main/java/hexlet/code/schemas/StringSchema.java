package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addPredicate((x) -> (x != null && !((String) x).isEmpty()));
        return this;
    }

    public StringSchema minLength(int length) {
        addPredicate((x) -> (x != null && ((String) x).length() >= length));
        return this;
    }

    public StringSchema contains(String str) {
        addPredicate((x) -> (x != null && ((String) x).contains(str)));
        return this;
    }

}
