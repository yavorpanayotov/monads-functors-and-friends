package functor;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctorTest {

    @Test
    public void fmapOnNothing_IsVoid() {
        assertEquals(new Nothing(), new Nothing().fmap(plus10()));
    }

    @Test
    public void fmapOnJust_MapsFunctionToInternalValue() {
        assertEquals(new Just(15), new Just(5).fmap(plus10()));
    }

    private Function<Integer, Integer> plus10() {
        return value -> value + 10;
    }
}