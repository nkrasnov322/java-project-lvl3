package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addPredicate((x) -> (x != null && x instanceof Integer));
        return this;
    }

    public NumberSchema positive() {
        addPredicate((x) -> (x == null) || ((Integer) x) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addPredicate((x) -> (x != null && ((Integer) x) >= min && ((Integer) x) <= max));
        return this;
    }
}
