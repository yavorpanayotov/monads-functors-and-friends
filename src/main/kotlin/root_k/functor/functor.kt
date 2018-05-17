package root_k.functor

import root_k.functor.Maybe.Just
import root_k.functor.Maybe.None

sealed class Maybe<out A> {
    object None : Maybe<Nothing>()
    data class Just<out A>(val value: A) : Maybe<A>()

    infix fun <B> fmap(f: (A) -> B): Maybe<B> = when (this) {
        is None -> this
        is Just -> Just(f(value))
    }
}

fun main(args: Array<String>) {
    None fmap { print("this will not be applied") } // None

    Just(5) fmap { it + 1 } fmap { it + 2 } // Just 8
}
