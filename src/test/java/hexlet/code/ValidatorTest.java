package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {
    @Test
    void stringSchemaTest() {
        Validator validator = new Validator();

        StringSchema stringSchema = validator.string();

        Assertions.assertTrue(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid("qwerty"));
        Assertions.assertTrue(stringSchema.isValid(null));

        stringSchema = validator.string();
        stringSchema.required();

        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid("qwerty"));
        Assertions.assertFalse(stringSchema.isValid(null));

        stringSchema = validator.string();
        final int minLength = 3;
        stringSchema.minLength(minLength);

        Assertions.assertTrue(stringSchema.isValid("123"));
        Assertions.assertTrue(stringSchema.isValid("qwerty"));
        Assertions.assertFalse(stringSchema.isValid(null));
        Assertions.assertFalse(stringSchema.isValid("12"));
        Assertions.assertFalse(stringSchema.isValid(""));

        stringSchema = validator.string();
        stringSchema.contains("internal string");

        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid("internal string"));
        Assertions.assertTrue(stringSchema.isValid("test internal string test"));

    }

    @Test
    public void numberSchemaTest() {

        Validator v = new Validator();
        final int four = 4;
        final int five = 5;
        final int ten = 10;
        final int eleven = 11;
        NumberSchema schema = v.number();

        Assertions.assertTrue(schema.isValid(null)); // true

        schema = v.number();
        schema.required();

        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertTrue(schema.isValid(ten));
        Assertions.assertFalse(schema.isValid("5")); // false

        schema = v.number();
        schema.positive();
        Assertions.assertTrue(schema.isValid(ten)); // true
        Assertions.assertFalse(schema.isValid(-ten)); // false

        schema = v.number();
        schema.range(five, ten);

        Assertions.assertTrue(schema.isValid(five)); // true
        Assertions.assertTrue(schema.isValid(ten)); // true
        Assertions.assertFalse(schema.isValid(four)); // false
        Assertions.assertFalse(schema.isValid(eleven)); // false
    }

    @Test
    public void mapSchemaTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Assertions.assertTrue(schema.isValid(null)); // true

        schema = v.map();
        schema.required();

        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertTrue(schema.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Assertions.assertTrue(schema.isValid(data)); // true

        schema = v.map();
        schema.sizeof(2);

        Assertions.assertFalse(schema.isValid(data));  // false
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data)); // true
    }
}
