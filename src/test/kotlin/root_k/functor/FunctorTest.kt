package root_k.functor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test
import root_k.functor.Maybe.Just
import root_k.functor.Maybe.None

class FunctorTest {

    @Test
    fun `flat mapping nothing has no effect`() {
        assertEquals(None, None fmap { fail<Unit>("should not be applied")})
    }

    @Test
    fun `fmap applies function on Just`() {
        assertEquals(Just(15), Just(5) fmap {it + 10})
    }
}