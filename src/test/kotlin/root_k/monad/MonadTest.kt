package root_k.monad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import root_k.monad.Maybe.Just
import root_k.monad.Maybe.None

class MonadTest {

    @Test
    fun `binding function to nothing has no effect`() {
        assertEquals(None, None bind { Just(it) })
    }

    @Test
    fun `binds function to when there's a value`() {
        assertEquals(Just(5), Just(10) bind {Just (it / 2)})
    }
}