package functor;

import java.util.function.Function;

public interface Functor<T> {
    Functor<T> fmap(Function<T, T> f);
}

abstract class Maybe<T> implements Functor<T> {
}

class Just<T> extends Maybe<T> {

    private final T value;

    Just(T value) {
        this.value = value;
    }

    @Override
    public Functor<T> fmap(Function<T, T> f) {
        return new Just(f.apply(value));
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Just && ((Just) other).value.equals(value);
    }
}

class Nothing<T> extends Maybe<T> {

    @Override
    public Functor<T> fmap(Function<T, T> f) {
        return this;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Nothing;
    }
}


