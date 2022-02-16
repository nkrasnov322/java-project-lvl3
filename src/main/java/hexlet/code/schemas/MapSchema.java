package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public void required() {
        addPredicate((x) -> (x instanceof Map));
    }

    public void sizeof(final int mapSize) {
        addPredicate((x) -> (x instanceof Map && ((Map) x).size() == mapSize));
    }

}
