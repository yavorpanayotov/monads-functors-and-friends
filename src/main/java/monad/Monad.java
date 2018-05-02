package monad;

import common.DataClass;

import java.util.function.Function;

public interface Monad<T> {
    Monad<T> bind(Function<T, ? extends Monad<T>> f);
}

abstract class Maybe<T> extends DataClass implements Monad<T> {
}

class Just<T> extends Maybe<T> {

    private final T value;

    Just(T value) {
        this.value = value;
    }

    @Override
    public Monad<T> bind(Function<T, ? extends Monad<T>> f) {
        return f.apply(value);
    }
}

class Nothing<T> extends Maybe<T> {

    @Override
    public Monad<T> bind(Function<T, ? extends Monad<T>> f) {
        return new Nothing<>();
    }
}