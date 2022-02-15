package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public final class StringSchema {

    private ArrayList<Predicate<String>> predicates;

    {
        predicates = new ArrayList<>();
    }

    public void required() {
        predicates.add((x) -> (x != null && !x.isEmpty()));
    }

    public void minLength(int length) {
        predicates.add((x) -> (x != null && x.length() >= length));
    }

    public void contains(String str) {
        predicates.add((x) -> (x != null && x.contains(str)));
    }

    public boolean isValid(String str) {
        for (Predicate<String> predicate: predicates) {
            if (!predicate.test(str)) {
                return false;
            }
        }
        return true;
    }




}
