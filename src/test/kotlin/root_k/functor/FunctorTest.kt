package root_k.functor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import root_k.functor.Maybe.Just
import root_k.functor.Maybe.None

class FunctorTest {

    @Test
    fun fmapOnNothing_IsVoid() {
        assertEquals(None, None `fmap` plus10())
    }

    @Test
    fun fmapOnJust_MapsFunctionToInternalValue() {
        assertEquals(Just(15), Just(5) `fmap` plus10())
    }

    private fun plus10(): (Int) -> Int {
        return { it + 10 }
    }
}