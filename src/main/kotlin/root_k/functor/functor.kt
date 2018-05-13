package root_k.functor

sealed class Maybe<out A> {
    object None : Maybe<Nothing>()
    data class Just<out A>(val value: A) : Maybe<A>()

    infix fun <B> fmap(f: (A) -> B): Maybe<B> = when (this) {
        is None -> this
        is Just -> Just(f(value))
    }
}

