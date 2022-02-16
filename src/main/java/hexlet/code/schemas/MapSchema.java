package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addPredicate((x) -> (x instanceof Map));
        return this;
    }

    public MapSchema sizeof(final int mapSize) {
        addPredicate((x) -> (x instanceof Map && ((Map) x).size() == mapSize));
        return this;
    }

    public MapSchema shape(final Map<String, BaseSchema> schemaMap) {
        addPredicate((x) -> (x instanceof Map
                                && schemaMap.entrySet().stream()
                .allMatch((schema) -> (((BaseSchema) schema.getValue())
                        .isValid(((Map<?, ?>) x).get(schema.getKey()))))));
        return this;
    }

}
