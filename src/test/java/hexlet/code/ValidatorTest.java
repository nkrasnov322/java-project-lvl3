package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
