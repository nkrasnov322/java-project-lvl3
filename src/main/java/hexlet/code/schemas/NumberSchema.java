package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public void required() {
        addPredicate((x) -> (x != null && x instanceof Integer));
    }

    public void positive() {
        addPredicate((x) -> (x != null) && ((Integer) x) > 0);
    }

    public void range(int min, int max) {
        addPredicate((x) -> (x != null && ((Integer) x) >= min && ((Integer) x) <= max));
    }
}
