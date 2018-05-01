package monad;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class MonadTest {

    @Test
    public void bindingFunctionToNothing_IsVoid() {
        assertAll(
                () -> assertEquals(new Nothing(), new Nothing().bind(value -> fail("shouldn't have called this"))),
                () -> assertEquals(new Nothing(), new Nothing().bind(half()))
        );
    }

    @Test
    public void bindsFunctionToJust() {
        assertEquals(new Just(5), new Just<>(10).bind(half()));
    }

    @Test
    public void canBindFunctionToJustMoreThanOnce() {
        assertEquals(new Just(4),
                new Just<>(16)
                        .bind(half())
                        .bind(half())
        );
    }

    private Function<Integer, Maybe<Integer>> half() {
        return value -> {
            if (value % 2 == 0) return new Just(value / 2);
            return new Nothing<>();
        };
    }
}