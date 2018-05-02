package common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DataClassTest {

    @Test
    public void objectsWithEqualFields_AreEqual() {
        assertEquals(new TestDataClassWithFields("value 1", "value 2"), new TestDataClassWithFields("value 1", "value 2"));
    }

    @Test
    public void objectsWithDifferentFields_AreNotEqual() {
        assertNotEquals(new TestDataClassWithFields("value 1", "value 2"), new TestDataClassWithFields("value 1", "value 3"));
    }
}

class TestDataClassWithFields extends DataClass {
    final String field1;
    final String field2;

    TestDataClassWithFields(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
