package root_k.monad

import root_k.monad.Maybe.Just
import root_k.monad.Maybe.None

sealed class Maybe<out A> {
    object None : Maybe<Nothing>()
    data class Just<out A>(val value: A) : Maybe<A>()

    infix fun <B> bind(f: (A) -> Maybe<B>): Maybe<B> = when (this) {
        is None -> this
        is Just -> f(value)
    }
}

fun main(args: Array<String>) {
    None bind { x ->
        print("this will not be applied")
        None
    } // None

    Just(10) bind { Just(it / 2) } // Just 5
}