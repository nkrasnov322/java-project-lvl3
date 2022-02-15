package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private ArrayList<Predicate<Object>> predicates;

    protected BaseSchema() {
        predicates = new ArrayList<>();
    }

    final void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public final boolean isValid(Object obj) {
        for (Predicate<Object> predicate: predicates) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }

}
