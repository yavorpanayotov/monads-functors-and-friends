package functor;

import common.DataClass;

import java.util.function.Function;

public interface Functor<T> {
    Functor<T> fmap(Function<T, T> f);
}

abstract class Maybe<T> extends DataClass implements Functor<T> {
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
}

class Nothing<T> extends Maybe<T> {

    @Override
    public Functor<T> fmap(Function<T, T> f) {
        return this;
    }
}


